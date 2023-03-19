package com.fmi.entertizer.coordinates;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CoordinationHandling {
    public static final double EARTH_RADIUS = 6371;
    private double fi_1;
    private double fi_2;
    private  double fi;
    private double lambda;
    private Coordinates startingPoint;
    //private static CoordinateList coordinateList;
    public static void main(String[] args) {
        //Coordinates coordinates = new Coordinates("49°30'60 N, 123°30'03 W");
        //Coordinates coordinates = new Coordinates("49°30'60 N");
        PointList pL = new PointList("3°0'40 N, 3°0'40 N","49°30'00\"N N, 123°30'0 W, 102°20'03 W, 164°20'03 W");

    }
    public boolean setStartingPoint(Coordinates startingPoint)
    {
        return false;
    }
    public CoordinationHandling(Coordinates A,Coordinates B)
    {

    }
    public CoordinationHandling(String input)
    {

    }
    private void parseInput(String input)
    {
        String coordinates[] =input.split(", ");

    }
}
class Point
{
    private Coordinates lat;
    private Coordinates lon;
    public Point(Coordinates lat,Coordinates lon)
    {
        this.lat = lat;
        this.lon = lon;
    }
    public Point(String input)
    {
        String inputCoords [] = input.split(", ");
        if(inputCoords.length!=2)
            return; // raise exception
        this.lat = new Coordinates(inputCoords[0]);
        this.lon = new Coordinates(inputCoords[1]);

    }

    public void print()
    {

        lat.printDD();
        lon.printDD();
    }
    public Coordinates getLat()
    {
        return lat;
    }
    public Coordinates getLon()
    {
        return lon;
    }
    public double distance(Point other)
    {
        double d,a,c;
        double phi_1 = Math.toRadians(this.lat.getDecDegree());
        double phi_2 = Math.toRadians(other.lat.getDecDegree());
        double delta_phi = Math.toRadians(other.lat.getDecDegree() - this.lat.getDecDegree());
        double delta_lambda = Math.toRadians(other.lon.getDecDegree() - this.lon.getDecDegree());

        a = Math.sin(delta_phi/2)*Math.sin(delta_phi/2) +
            Math.cos(phi_1) * Math.cos(phi_2) *
            Math.sin(delta_lambda/2)*Math.sin(delta_lambda/2);
        c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        d = CoordinationHandling.EARTH_RADIUS* c;
        return  d;
    }
}
class PointList
{
    private Point currentPos;
    private ArrayList<Point> pointLists;
    private TreeMap<Double,Point> savedSearch;
    public PointList(Point currentPos,String input)
    {
        setCurrentPos(currentPos);
        pointLists = new ArrayList<>();
        parseInput(input);
        sortPointLists();
        printSavedSearch();
    }
    public PointList(String currentPosInput,String input)
    {
        setCurrentPos(new Point(currentPosInput));
        pointLists = new ArrayList<>();
        parseInput(input);
        sortPointLists();
        printSavedSearch();
    }
    public void sortPointLists()
    {
        if(savedSearch.isEmpty())
            for(Point p:pointLists)
                savedSearch.put(currentPos.distance(p),p);

    }
    public Point getCurrentPos()
    {
        return currentPos;
    }
    public void setCurrentPos(Point p)
    {
        savedSearch = new TreeMap<>();
        currentPos = p;
    }
    public void setCurrentPos(Coordinates lat,Coordinates lon)
    {
        currentPos = new Point(lat, lon);
    }
    public ArrayList<Point> getPointLists()
    {
        return this.pointLists;
    }
    public TreeMap<Double,Point> getSavedSearch()
    {
        return savedSearch;
    }
    public void printSavedSearch()
    {
        for(Map.Entry<Double,Point> entry:savedSearch.entrySet())
        {
            //System.out.println(entry.getKey() + " " + entry.getValue().print());
            System.out.println(entry.getKey() + " ");  entry.getValue().print();
        }
    }
    public void printCoordinates()
    {
        for(Point p:pointLists)
        {
            p.getLat().printDD();
            p.getLon().printDD();
        }
    }
    private void parseInput(String input)
    {
        String inputCoords [] = input.split(", ");
        for(int i=0;i<inputCoords.length;i+=2)
        {
            Coordinates coordinateLat = new Coordinates(inputCoords[i]);
            Coordinates coordinatesLon = new Coordinates(inputCoords[i+1]);
            Point point = new Point(coordinateLat,coordinatesLon);
            this.pointLists.add(point);
        }
    }

}
class Coordinates
{

    private int degree;
    private int hours;
    private int minutes;
    private double decDegree;
    public Coordinates(int degree,int hours,int minutes)
    {
        setDegree(degree);
        setHours(hours);
        setMinutes(minutes);
        System.out.print(DMSToDD(degree,hours,minutes));
    }
    public Coordinates(String coordinates)
    {
        parseCoordinates(coordinates);
        printDMS();
        printDD();
    }
    public double getDecDegree()
    {
        return this.decDegree;
    }

    public void printDMS()
    {
        System.out.printf("DMS : %d°%d'%d\"\n",degree,hours,minutes);
    }
    public void printDD()
    {
        System.out.printf("DD : %.5f\n",decDegree);
    }
    public int getDegree()
    {
        return this.degree;
    }
    public int getHours()
    {
        return this.hours;
    }
    public int getMinutes()
    {
        return this.minutes;
    }
    private double DMSToDD(int degree,int hours,int minutes)
    {
        decDegree = (double)degree+(double)hours/60 + (double)minutes/3600;
      //  decDegree = (double)degree+((double)hours/60)+((double)minutes/3600);
        return decDegree;
    }
    private boolean setDMS(Matcher matcher)
    {
        int k = 0;
        while(matcher.find())
        {
            switch (k++)
            {
                case 0:{setDegree(Integer.parseInt(matcher.group()));break;}
                case 1:{setHours(Integer.parseInt(matcher.group()));break;}
                case 2:{setMinutes(Integer.parseInt(matcher.group()));break;}
                default:{return false;}
            }
        }
        DMSToDD(degree,hours,minutes);
        return true;
    }
    private void parseCoordinates(String coordinates) // dopishi parse
    {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(coordinates);
        if(!setDMS(matcher))
        {
            System.out.print("Error In Matching!\n");
        }
    }
    private void setDegree(int degree)
    {
        this.degree = degree;
    }
    private void setHours(int hours)
    {
        this.hours = hours;
    }
    private void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }
}
