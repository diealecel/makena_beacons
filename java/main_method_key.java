import java.util.Arrays;
import java.io.Console;
import java.util.Scanner;
import java.lang.*;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event; 

public class main_method_key {
  public static final double EPSILON = .00001;
  public double x, y;
  public Beacon[] beacons = new Beacon[3];

  public double[] triangulate(double x0, double y0, double r0, double x1, double y1, double r1, double x2, double y2, double r2) {
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
   
         int map_length = 5000;  
         int map_width = 5000;  
         int offset = 100; 
          int beacon_size = 25;

           double x, y; 
        System.out.println("Target X");  
        x = in.nextInt(); 
        System.out.println("Target Y");  
        y = in.nextInt(); 
        
         Beacon b0 = new Beacon(0, 450, 485); 
          beacons[0] = b0; 
          Beacon b1 = new Beacon(1, 435, 10); 
         beacons[1] = b1; 
         Beacon b2 = new Beacon(2, 50, 10); 
         beacons[2] = b2; 
         set_radii(x,y); 

        Mapper map = new Mapper(map_length, map_width, x, y, beacons[0], beacons[1], beacons[2]);

        System.out.println("Press any key to add beacons...");
        while(!in.hasNext());
        in.nextLine(); 
        in.nextLine(); 
        map.addBeacons(x, y, beacons[0], beacons[1], beacons[2]);
    

        System.out.println("Press any key to add circles...");
        while(!in.hasNext());
        in.nextLine(); 
        map.addCircles(x, y, beacons[0], beacons[1], beacons[2]);

        System.out.println("Press enter to start tracking...");
        while(!in.hasNext());
        while(true); 

       }  
     

     public void keyPressed(KeyEvent e) {
      int code = e.getKeyCode();
        if (code == KeyEvent.VK_DOWN) {
            y++; 
            set_radii(x,y); 
            map.updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
        }
        if (code == KeyEvent.VK_UP) {
            y--; 
           set_radii(x,y);
            map.updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
        }
        if (code == KeyEvent.VK_LEFT) {
            x--; 
           set_radii(x,y);
            map.updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
        }
        if (code == KeyEvent.VK_RIGHT) {
            x++; 
           set_radii(x,y);
            map.updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
        }
      }

    public void set_radii(double x, double y){
      beacons[0].set_radius(Math.sqrt(   Math.pow(   beacons[0].get_x() - x, 2  )   +   Math.pow(   beacons[0].get_y() - y, 2  )));
      beacons[1].set_radius(Math.sqrt(   Math.pow(   beacons[1].get_x() - x, 2  )   +   Math.pow(   beacons[1].get_y() - y, 2  )));
      beacons[2].set_radius(Math.sqrt(   Math.pow(   beacons[2].get_x() - x, 2  )   +   Math.pow(   beacons[2].get_y() - y, 2  )));
    }
  }

