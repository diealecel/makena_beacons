

public class Beacon{
    private int beacon_id;
    private double beaconx;
    private double beacony;

    public Beacon(int id, double x, double y) {
        beacon_id = id;
        beaconx = x;
        beacony = y;
    }

    public int get_ID() {
        return beacon_id;
    }

    public double get_x() {
        return beaconx;
    }

    public double get_y() {
        return beacony;
    }

}
