#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include <cmath>
#include <array.h>
#include "beacon.cpp"

#define NUM_BEACONS 7
#define EPSILON 0.00001

//int beacon_ids[NUM_BEACONS] = {}                                                                                                                                                                        

int main(){
 
  // Map Initialization
  double map_length = -1;  
  cout << "Enter map length" << endl; 
  cin << map_length; 
  while(map_length < 0){
    cout << "Please enter a positivie map length" << endl; 
    cin << map_length; 
  }
  double map_width = -1; 
  cout <<"Enter map width" << endl; 
  cin << map_width; 
  while(map_width < 0){
    cout << "Please enter a positivie map width" << endl; 
    cin << map_width; 
  }
  cout << "Map dimensions: (" << map_length << ", " << map_width ")" << endl; 

  //build map                                                                                                                                                                                             

  

  Beacon beacons[NUM_BEACONS];
  //Initialize the beacons 

    for(int i=0; i<NUM_BEACONS; i++){                                                                                                                                                                       
       double bx = -1;                                                                                                                                                                                        
      cout << "Enter x coordinate for beacon " << i << ":" << endl; 
      cin << bx;  
      while(bx < 0 || bx > map_width){
         cout << "Beacon " << i << " out of bounds, please enter valid x coordinate" << endl;
         cin << bx;  
      }
      double by = -1;                                                                                                                                                                                        
      cout << "Enter y coordinate for beacon " << i << ":" << endl; 
      cin << by;   
      while(by < 0 || by > map_length){
          cout << "Beacon " << i << " out of bounds, please enter valid y coordinate" << endl;
          cin << by;    
     }                                                                                                                                                                                        
      Beacon b;                                                                                                                                                                                             
      b.beacon_init(i, bx, by);                                                                                                                                                               
      beacons[i] = b;                                                                                                                                                                                      
  }          

  for(int i =0; i<NUM_BEACONS; i++){
    cout << beacons[i]; 
  }                                                                                                                                                                                           

  //wait for user to be ready for tracking                                                                                                                                                                
  system("pause");

  while(true){
      //get beacon numbers and radii from app                                                                                                                                                                                                                                                                                                                                                                
      int b0, b1, b2;                                                                                                                                                                                     
      double r0, r1, r2;                                                                                                                                                                                  
      //get data                                                                                                                                                                                          
      //calculateThreeCircleIntersection(beacons[b0].getx(), beacons[b0].gety(), r0, beacons[b1].getx(), beacons[b1].gety(), r1, beacons[b2].getx(), beacons[b2].gety(), r2);                               
      // graphics                                                                                                                                                                                     
 }                                                                                                                                                                                                                                                                                                                                                                       
  return 1;
}

