#include "beacon.h"

include "beacon.h"

void beacon_init(int id, double x, double y){
  beacon_id = id;
  beaconx = x;
  beacony = y;
}

int get_ID(){
  return beacon_id;
}

double get_x(){
  return beaconx;
}

double get_y(){
  return beacony;
}
