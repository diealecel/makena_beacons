

public class Beacon{
    private int beacon_id;
    private double beaconx;
    private double beacony;
    private double radius; 

    public Beacon(int id, double x, double y) {
        beacon_id = id;
        beaconx = x;
        beacony = y;
        radius = 0; 
    }

    public void set_radius(double r){
        radius = r; 
    }

    public double get_radius(){
        return radius; 
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
