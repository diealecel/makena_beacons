#include "beacon.h"

Beacon::Beacon(int id, double x, double y) {
    this->id = id;
    this->x_pos = x;
    this->y_pos = y;
}

int Beacon::get_ID() const {
    return id;
}

double Beacon::get_x() const {
    return x_pos;
}

double Beacon::get_y() const {
    return y_pos;
}

ostream& operator<<(ostream& out, const Beacon& b) {
    out << "Beacon " << b.get_ID() << " at (" << b.get_x() << ", " << b.get_y() << ")" << endl;
    return out;
}
