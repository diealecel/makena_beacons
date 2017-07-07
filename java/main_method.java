import java.util.Arrays;
import java.io.Console;
import java.util.Scanner;
import java.lang.*;

public class main_method {
    public static final double EPSILON = .00001;

    public static double[] triangulate(double x0, double y0, double r0, double x1, double y1, double r1, double x2, double y2, double r2) {
        double a, dx, dy, d, h, rx, ry;
        double point2_x, point2_y;
        
        // |dx| and |dy| are the vertical and horizontal distances between the
        // circle centers.
        dx = x1 - x0;
        dy = y1 - y0;
        
        // Determine the straight-line distance between the centers.
        d = Math.sqrt(dx * dx + dy * dy);
        
        // Check for solvability using geometric laws.
        
        if(d > r0 + r1) {
            double[] return_val = {0,0}; 
            return return_val;  // No solution. Circles do not intersect.
        }
        
        if(d < Math.abs(r0 - r1)) {
            double[] return_val = {0,0}; 
            return return_val; // No solution. One circle is contained within the other.
        }
        
        // "Point 2" is the point where the line through the circle intersection
        // points crosses the line between the circle centers.
        
        // Determine the distance between point 0 and point 2.
        a = (r0 * r0 + r1 * r1 + d * d) / (2.0 * d);
        
        // Determine the coordinates of point 2.
        point2_x = x0 + dx * a / d;
        point2_y = y0 + dy * a / d;
        
        // Determine the distance from point 2 to either of the intersection
        // points.
        h = Math.sqrt(r0 * r0 - a * a);
        
        // Now determine the offsets of the intersection points from point 2.
        rx = -dy * h / d;
        ry = dx * h / d;
        
        // Determine the absolute intersection points.
        double intersection_pt1_x = point2_x + rx;
        double intersection_pt2_x = point2_x - rx;
        double intersection_pt1_y = point2_y + ry;
        double intersection_pt2_y = point2_y - ry;
        
        // Let's determine if circle 3 at either of the above intersection points.
        dx = intersection_pt1_x - x2;
        dy = intersection_pt1_y - y2;
        double d1 = Math.sqrt(dx * dx + dy * dy);
        
        dx = intersection_pt2_x - x2;
        dy = intersection_pt2_y - y2;
        double d2 = Math.sqrt(dx * dx + dy * dy);
        
        if(Math.abs(d1 - r2) < EPSILON) {
            double[] return_val = {intersection_pt1_x, intersection_pt1_y}; 
            return return_val;
        } else if(Math.abs(d2 - r2) < EPSILON) {
            double[] return_val = {intersection_pt2_x, intersection_pt2_y}; 
            return return_val;
        } else {
            System.out.println("Found no intersection among all three circles.");
            double[] return_val = {0,0}; 
            return return_val;
        }
    }
    


	public static void main(String args[]){
		Console console = System.console();
		Scanner in = new Scanner(System.in);

		double map_length = -1;  
		System.out.println("Map Length? ");
  	  	map_length = in.nextInt();
  	  	 while(map_length < 0){
  	  	 	System.out.println("Please enter a positivie map length");
      	   map_length = in.nextInt();
    	  }
  	   double map_width = -1;  
  	   System.out.println("Map Width? ");
  	   map_width = in.nextInt();
  	   while(map_width < 0){
  	   		System.out.println("Please enter a positivie map width");
  	        map_width = in.nextInt(); 
      	}
     	System.out.println("Map length = " + map_length +", Map width = " + map_width); 

     	Beacon[] beacons = new Beacon[7];


     	 for(int i=0; i<7; i++){                                                                                                                                                                       
       		 double bx = -1;                                                                                                                                                                                        
      		 System.out.println("Enter x coordinate for beacon " + i); 
      		 bx = in.nextInt();
      	 	while(bx < 0 || bx > map_width){
        		 System.out.println("Beacon " + i + " out of bounds, please enter valid x coordinate"); 
        		 bx = in.nextInt();   
    	  }
         double by = -1;                                                                                                                                                                                        
          System.out.println("Enter y coordinate for beacon " + i); 
      	 by = in.nextInt(); 
      	 while(by < 0 || by > map_width){
         	 System.out.println("Beacon " + i + " out of bounds, please enter valid y coordinate");  
        	 by = in.nextInt(); 
    	  }  
    	  Beacon b = new Beacon(i, bx, by);                                                                                                                                                                  
      	  beacons[i] = b; 
      	}

        double x, y; 
        System.out.println("Target X");  
        x = in.nextInt(); 
        System.out.println("Target Y");  
        y = in.nextInt(); 

        beacons[0].set_radius(Math.sqrt(   Math.pow(   beacons[0].get_x() - x , 2  )   +   Math.pow(   beacons[0].get_y() - y , 2  )));
        beacons[1].set_radius(Math.sqrt(   Math.pow(   beacons[1].get_x() - x , 2  )   +   Math.pow(   beacons[1].get_y() - y , 2  )));
        beacons[2].set_radius(Math.sqrt(   Math.pow(   beacons[2].get_x() - x , 2  )   +   Math.pow(   beacons[2].get_y() - y , 2  )));

        initializeGraphics(map_length, map_width, x, y, beacons[0], beacons[1], beacons[2]);

      	while(true){   
          System.out.println("Target X");  
          x = in.nextInt(); 
          System.out.println("Target Y");  
          y = in.nextInt(); 

          beacons[0].set_radius(Math.sqrt(   Math.pow(   beacons[0].get_x() - x , 2  )   +   Math.pow(   beacons[0].get_y() - y , 2  )));
          beacons[1].set_radius(Math.sqrt(   Math.pow(   beacons[1].get_x() - x , 2  )   +   Math.pow(   beacons[1].get_y() - y , 2  )));
          beacons[2].set_radius(Math.sqrt(   Math.pow(   beacons[2].get_x() - x , 2  )   +   Math.pow(   beacons[2].get_y() - y , 2  )));

          updateBoard(x, y, beacons[0], beacons[1], beacons[2]);

          /*                                                                                                                                                                                                                                                                                                                                                    
     		  System.out.println("Enter distance to Beacon 0");  
          r0 = in.nextInt();   
          System.out.println("Enter distance to Beacon 1");  
          r1 = in.nextInt();   
          System.out.println("Enter distance to Beacon 2");  
          r2 = in.nextInt();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
    		  triangulate(beacons[0].get_x(), beacons[0].get_y(), r0, beacons[1].get_x(), beacons[1].get_y(), r1, beacons[2].get_x(), beacons[2].get_y(), r2);
          */

 		}  
 	}
 }