package com.fmi.entertizer.coordinates;

public class Point {
    private Coordinates lat;
    private Coordinates lon;

    public Point(String lat, String lon) {
        this.lat = new Coordinates(lat);
        this.lon = new Coordinates(lon);
    }

    public Point(Coordinates lat, Coordinates lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Point(String input) {
        String inputCoords[] = input.split(", ");
        if (inputCoords.length != 2)
            return; // raise exception
        this.lat = new Coordinates(inputCoords[0]);
        this.lon = new Coordinates(inputCoords[1]);

    }

    public String print() {
        return lat.printDD()+(lat.getDecDegree()>0?"N":"S") + lon.printDD() + (lat.getDecDegree()>0?"E":"W");
    }

    public Coordinates getLat() {
        return lat;
    }

    public Coordinates getLon() {
        return lon;
    }

    public double distance(Point other) {
        double d, a, c;
        double phi_1 = Math.toRadians(this.lat.getDecDegree());
        double phi_2 = Math.toRadians(other.lat.getDecDegree());
        double delta_phi = Math.toRadians(other.lat.getDecDegree() - this.lat.getDecDegree());
        double delta_lambda = Math.toRadians(other.lon.getDecDegree() - this.lon.getDecDegree());

        a = Math.sin(delta_phi / 2) * Math.sin(delta_phi / 2) +
                Math.cos(phi_1) * Math.cos(phi_2) *
                        Math.sin(delta_lambda / 2) * Math.sin(delta_lambda / 2);
        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        d = CoordinationHandling.EARTH_RADIUS * c;
        return d;
    }
}
