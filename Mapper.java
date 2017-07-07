import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class Mapper extends GraphicsProgram {
 
   public void run(int map_length, int map_width, double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2) {
      GOval oval = new GOval(target_x, target_y, 25, 25);
      oval.setFilled(true);
      oval.setColor(Color.GREEN);
      add(oval);

      GOval beacon_1 = new GOval(b0.get_x(), b0.get_y(), b0.get_radius(), b0.get_radius());
      oval.setFilled(false);
      oval.setColor(Color.BLACK);
      add(oval);

      GOval beacon_2 = new GOval(b1.get_x(), b1.get_y(), b1.get_radius(), b1.get_radius());
      oval.setFilled(false);
      oval.setColor(Color.BLACK);
      add(oval);

      GOval beacon_3 = new GOval(b2.get_x(), b2.get_y(), b2.get_radius(), b2.get_radius());
      oval.setFilled(false);
      oval.setColor(Color.BLACK);
      add(oval);
   }
 
/** Constant representing the golden ratio */
   public static final double PHI = 1.618;
 
} 