package com.fmi.entertizer.coordinates;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PointList {
    private Point currentPos;
    private ArrayList<Point> pointLists;
    private TreeMap<Double, Point> savedSearch;

    public PointList() {
        pointLists = new ArrayList<>();
    }

    public PointList(Point currentPos, String input) {
        setCurrentPos(currentPos);
        pointLists = new ArrayList<>();
        parseInput(input);
        sortPointLists();
        printSavedSearch();
    }

    public PointList(String currentPosInput, String input) {
        setCurrentPos(new Point(currentPosInput));
        pointLists = new ArrayList<>();
        parseInput(input);
        sortPointLists();
        System.out.print(printSavedSearch());
    }

    public void sortPointLists() {
        if (savedSearch.isEmpty())
            for (Point p : pointLists)
                savedSearch.put(currentPos.distance(p), p);

    }

    public void addPoint(Coordinates lat, Coordinates lon) {
        pointLists.add(new Point(lat, lon));
        sortPointLists();
    }

    public void addPoint(Point p) {
        pointLists.add(p);
        sortPointLists();
    }

    public Point getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Point p) {
        savedSearch = new TreeMap<>();
        currentPos = p;
        sortPointLists();
    }

    public void setCurrentPos(Coordinates lat, Coordinates lon) {
        currentPos = new Point(lat, lon);
    }

    public ArrayList<Point> getPointLists() {
        return this.pointLists;
    }

    public TreeMap<Double, Point> getSavedSearch() {
        return savedSearch;
    }

    public String printSavedSearch() {
        StringBuilder str = new StringBuilder(512);
        for (Map.Entry<Double, Point> entry : savedSearch.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue().print());
            str.append(entry.getKey() + " ").append(entry.getValue().print());
        }
        return str.toString();
    }

    public String printCoordinates() {
        StringBuilder str = new StringBuilder(512);
        for (Point p : pointLists) {
            str.append(p.getLat().printDD()).append(p.getLon().printDD());
        }
        return str.toString();
    }

    private void parseInput(String input) {
        String inputCoords[] = input.split(", ");
        for (int i = 0; i < inputCoords.length; i += 2) {
            Coordinates coordinateLat = new Coordinates(inputCoords[i]);
            Coordinates coordinatesLon = new Coordinates(inputCoords[i + 1]);
            Point point = new Point(coordinateLat, coordinatesLon);
            this.pointLists.add(point);
        }
    }

}
