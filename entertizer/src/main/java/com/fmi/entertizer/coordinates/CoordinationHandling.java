package com.fmi.entertizer.coordinates;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CoordinationHandling {
    public static final double EARTH_RADIUS = 6371;
    private Coordinates startingPoint;
    private PointList pointList;
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
        System.out.print(printDMS());
    }
    public Coordinates(String coordinates)
    {
        parseCoordinates(coordinates);
        System.out.print(printDMS());
        System.out.print(printDD());
    }
    public double getDecDegree()
    {
        return this.decDegree;
    }

    public String printDMS()
    {
        return String.format("DMS : %d°%d'%d\"\n",degree,hours,minutes);
    }
    public String printDD()
    {
        return String.format("DD : %.5f\n",decDegree);
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
