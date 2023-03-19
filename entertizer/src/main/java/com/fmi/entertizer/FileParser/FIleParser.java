package com.fmi.entertizer.FileParser;

import org.apache.tomcat.Jar;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.parameters.P;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fmi.entertizer.model.entity.enums.PlaceType;
public class FIleParser {


    private File file = null;
    private Scanner scanner = null;

    private LinkedList<ArrayList<String>> locationsRaw;
    public FIleParser(String path,String fileName)
    {
        openFile(path+'\\'+fileName);
    }
    public FIleParser(String fullPath)
    {
        openFile(fullPath);
    }
    public void openFile(String fullPath)
    {
        HashMap<String,Integer> propertyMapping = new HashMap<>();
        HashMap<String,String> info = new HashMap<>();
        String properties[] = {"address_line2","name","lat","lon","categories"};

        int i =0;
        for(String pr:properties)
        {
            propertyMapping.put(pr,i++);
        }
        Pattern propPattern = Pattern.compile("address_line2|name|lon|lat|categories");
        Pattern coordPattern = Pattern.compile("\\d+.\\d+");
        Pattern textPattern = Pattern.compile(": \"{1}.*\"{1}");
        Pattern textPattern2 = Pattern.compile("\"(.*?)\"+");
        Matcher matcher;
        try
        {
            file = new File(fullPath);
            scanner = new Scanner(file);
        }catch (FileNotFoundException e)
        {
            System.err.printf("FileNotFound + %s",fullPath);
            e.printStackTrace();
        }
        String tokens[];
        String line;
        String prop;
        locationsRaw = new LinkedList<>();
        System.out.printf("\n\nReading from: %s\n\n",file.getName());
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            if(line.isEmpty())
                continue;
            tokens = line.split(":");
            if(tokens.length!=2)
                continue;
            matcher = propPattern.matcher(tokens[0]);
            if(matcher.find()) // WE FOUND INFO WE WANT
            {
                prop = matcher.group();
                switch (propertyMapping.get(prop))
                {
                    case 0:// adress
                    case 1:
                    {
                        matcher = textPattern.matcher(line);
                        if(matcher.find())
                        {
                            String c = matcher.group();
                            matcher = textPattern2.matcher(c);
                            if(matcher.find())
                            {
                                info.put(prop,matcher.group());
                            }
                        }
                        break;
                    } //name
                    case 2://lat
                    case 3:
                    {
                        matcher = coordPattern.matcher(tokens[1]);
                        if(matcher.find())
                        {
                            info.put(prop,matcher.group());
                        }
                        break;
                    } //lon
                    case 4:
                    {
                        if(scanner.hasNextLine())
                            line = scanner.nextLine();
                        matcher = Pattern.compile("\\w+").matcher(line);
                        if(matcher.find())
                        {
                            String c = matcher.group();
                            PlaceType pt[] = PlaceType.values();
                            boolean found = false;
                            for(PlaceType placeType:pt)
                            {
                                if(placeType.toString().equals(c.toUpperCase()))
                                {
                                    found = true;
                                    info.put(prop,PlaceType.valueOf(c.toUpperCase()).toString());
                                    break;
                                }
                            }
                            if(!found)
                                info.put(prop,"NaN");
                            ArrayList<String> newLoc = new ArrayList<>();
                            locationsRaw.add(newLoc);
                            for(String s:properties)
                            {
                                locationsRaw.getLast().add(info.get(s));
                             //   System.out.printf("New Order %s %s\n",s,info.get(s));
                            }
                            /*
                            for(Map.Entry<String,String> e:info.entrySet())
                            {
                               // locationsRaw.getLast().add(e.getValue());
                                System.out.printf("I AM HERE %s %s\n",e.getKey(),e.getValue());
                            }System.out.println();*/
                        }
                        break;
                    } //categories
                }
            }

        }
    }
    public LinkedList<ArrayList<String>> getLocationsRaw()
    {
        return locationsRaw;
    }
}

