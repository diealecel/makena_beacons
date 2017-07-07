import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Mapper extends GraphicsProgram {

GOval target, beacon_1, beacon_1r, beacon_2, beacon_2r, beacon_3, beacon_3r; 
 
   public void initializeBoard(int map_length, int map_width, double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2) {
    	setSize(1000, 2000);
    	pause(10);
    	/*
    	GPolygon room = new GPolygon(500, 1000); 
    	room.addVertex();
    	room.addVertex();
    	room.addVertex();
    	room.addVertex();
    	room.addVertex();
    	room.addEdge(); 
    	room.addEdge(); 
    	room.addEdge(); 
    	room.addEdge(); 
    	room.addEdge(); 
		*/

    	//Adjust coordinates for offsets
     	target = new GOval(target_x, target_y, 25, 25);
     	target.setFilled(true);
     	target.setColor(Color.GREEN);
     	add(target);

      	beacon_1 = new GOval(b0.get_x(), b0.get_y(), 5, 5);
      	beacon_1.setFilled(true);
      	beacon_1.setColor(Color.BLUE);
      	add(beacon_1);

      	beacon_1r = new GOval(b0.get_x(), b0.get_y(), b0.get_radius(), b0.get_radius());
      	beacon_1r.setFilled(false);
      	beacon_1r.setColor(Color.BLACK);
      	add(beacon_1r);

      	beacon_2 = new GOval(b1.get_x(), b1.get_y(), 5, 5);
      	beacon_2.setFilled(true);
      	beacon_2.setColor(Color.BLUE);
      	add(beacon_2);

      	beacon_2r = new GOval(b1.get_x(), b1.get_y(), b1.get_radius(), b1.get_radius());
      	beacon_2r.setFilled(false);
      	beacon_2r.setColor(Color.BLACK);
      	add(beacon_2r);

      	beacon_3 = new GOval(b2.get_x(), b2.get_y(), 5, 5);
      	beacon_3.setFilled(true);
      	beacon_3.setColor(Color.BLUE);
      	add(beacon_3);

     	beacon_3r = new GOval(b2.get_x(), b2.get_y(), b2.get_radius(), b2.get_radius());
     	beacon_3r.setFilled(false);
     	beacon_3r.setColor(Color.BLACK);
     	add(beacon_3r);
   }

   public void updateBoard(double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2) {
   		target.setLocation(target_x, target_y); 
   		beacon_1r.setSize(b0.get_radius(), b0.get_radius()); 
   		beacon_2r.setSize(b1.get_radius(), b1.get_radius()); 
   		beacon_3r.setSize(b2.get_radius(), b2.get_radius()); 
   }
 
/** Constant representing the golden ratio */
   public static final double PHI = 1.618;
 
} 