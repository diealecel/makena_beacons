// WOW
#ifndef _beacon_h
#define _beacon_h

#include <iostream>
#include <string>

using namespace std;

class Beacon {
public:
   	void beacon_init(int id, double x, double y);
	int getID() const;
	double getx() const;
	double gety() const;

private:
	int beacon_id;
    double beaconx;
  	double beacony;
};

#endif
