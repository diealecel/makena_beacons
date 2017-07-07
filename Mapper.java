import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Mapper extends GraphicsProgram {
 
   public void run(int map_length, int map_width, double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2) {
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
     	 GOval target = new GOval(target_x, target_y, 25, 25);
     	 target.setFilled(true);
     	 target.setColor(Color.GREEN);
     	 add(target);

      	GOval beacon_1 = new GOval(b0.get_x(), b0.get_y(), 5, 5);
      	beacon_1.setFilled(true);
      	beacon_1.setColor(Color.BLUE);
      	add(beacon_1);

      	GOval beacon_1r = new GOval(b0.get_x(), b0.get_y(), b0.get_radius(), b0.get_radius());
      	beacon_1r.setFilled(false);
      	beacon_1r.setColor(Color.BLACK);
      	add(beacon_1r);

      	GOval beacon_2 = new GOval(b1.get_x(), b1.get_y(), 5, 5);
      	beacon_2.setFilled(true);
      	beacon_2.setColor(Color.BLUE);
      	add(beacon_2);

      	GOval beacon_2r = new GOval(b1.get_x(), b1.get_y(), b1.get_radius(), b1.get_radius());
      	beacon_2r.setFilled(false);
      	beacon_2r.setColor(Color.BLACK);
      	add(beacon_2r);

      	GOval beacon_3 = new GOval(b2.get_x(), b2.get_y(), 5, 5);
      	beacon_3.setFilled(true);
      	beacon_3.setColor(Color.BLUE);
      	add(beacon_3);

     	 GOval beacon_3r = new GOval(b2.get_x(), b2.get_y(), b2.get_radius(), b2.get_radius());
     	 beacon_3r.setFilled(false);
     	 beacon_3r.setColor(Color.BLACK);
     	 add(beacon_3r);
   }
 
/** Constant representing the golden ratio */
   public static final double PHI = 1.618;
 
} 