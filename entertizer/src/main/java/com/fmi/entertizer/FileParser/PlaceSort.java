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

public class PlaceSort {
    private String filePath = "entertizer/src/main/java/com/fmi/entertizer/FileParser/jsonTest.txt";
    private FIleParser fIleParser;
    private TreeMap<Long,Place> placesSorted;
    private PointList pointList;
    public PlaceSort(Point p)
    {
        placesSorted = new TreeMap<>();
        pointList = new PointList();
        pointList.setCurrentPos(p);
        fIleParser = new FIleParser(filePath);
        input();
        for(Map.Entry<Long,Place> e:placesSorted.entrySet())
        {
            System.out.println("PLACES INPUT "+e.getValue().getName()+" "+e.getKey());
        }
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
