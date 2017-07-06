#include "beacon.h"

Beacon::Beacon(int id, double x, double y) {
    beacon_id = id;
    beaconx = x;
    beacony = y;
}

int Beacon::get_ID() const {
    return beacon_id;
}

double Beacon::get_x() const {
    return beaconx;
}

double Beacon::get_y() const {
    return beacony;
}

ostream& operator<<(ostream& out, const Beacon& b) {
    out << "Beacon " << b.get_ID() << " at (" << b.get_x() << ", " << b.get_y() << ")" << endl;
    return out;
}
