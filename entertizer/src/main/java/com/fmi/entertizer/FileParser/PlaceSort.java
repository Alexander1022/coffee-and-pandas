package com.fmi.entertizer.FileParser;

import com.fmi.entertizer.coordinates.PointList;
import com.fmi.entertizer.model.entity.Place;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import com.fmi.entertizer.coordinates.Point;
import com.fmi.entertizer.model.entity.enums.PlaceType;
import com.sun.source.tree.Tree;

public class PlaceSort {
    private String filePath = "entertizer/src/main/java/com/fmi/entertizer/FileParser/jsonTest.txt";
    private FIleParser fIleParser;
    private TreeMap<Long,Place> placesSorted;
    private PointList pointList;
    public PlaceSort(String filePath,Point p)
    {
        this.filePath = filePath;
        placesSorted = new TreeMap<>();
        pointList = new PointList();
        pointList.setCurrentPos(p);
        fIleParser = new FIleParser(filePath);
        input();
        System.out.print(printSort());
    }
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    public String getFilePath()
    {
        return filePath;
    }
    public TreeMap<Long,Place> getSortedPoints()
    {
        return placesSorted;
    }
    public String printSort()
    {
        StringBuilder str = new StringBuilder(512);
        for(Map.Entry<Long,Place> e:placesSorted.entrySet())
        {
            str.append("PLACES INPUT").append(e.getValue().getName()).append(' ').append(e.getKey()).append('\n');
        }
        return str.toString();
    }
    public void input()
    {
        LinkedList<ArrayList<String>> places;
        places = fIleParser.getLocationsRaw();
        for(ArrayList<String> list:places)
        {
            PlaceType placeType;
            try {
                 placeType  = PlaceType.valueOf(list.get(4));
            }catch (IllegalArgumentException e)
            {
                placeType = PlaceType.BAR;
            }

            Point p =  new Point(list.get(2),list.get(3));
            Place place = new Place(placeType,list.get(0),list.get(1),list.get(2)+", "+list.get(3));
            pointList.addPoint(p);
            placesSorted.put((long)pointList.getCurrentPos().distance(p),place);
        }
    }

}
