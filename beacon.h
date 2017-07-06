#ifndef _beacon_h
#define _beacon_h

#include <iostream>
#include <string>

using namespace std;

class Beacon {
public:
    Beacon(int id, double x, double y);
    int get_ID() const;
    double get_x() const;
    double get_y() const;
    friend ostream& operator <<(ostream& out, const Beacon& b);

private:
    int id;
    double x_pos;
    double y_pos;
};

#endif
