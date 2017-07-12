import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import javax.swing.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mapper extends GraphicsProgram {
  Timer t = new Timer(5, this);
  private GOval target, beacon_0, beacon_0r, beacon_1, beacon_1r, beacon_2, beacon_2r; 
  private GLine line0, line1, line2;
  private  GCanvas canvas = new GCanvas();
  int beacon_size = 25;
  int target_size = 25; 
  int offset = 200; 
  double x, y; 
  Beacon b0 = new Beacon(0, 450, 485); 
  Beacon b1 = new Beacon(1, 435, 10); 
  Beacon b2 = new Beacon(2, 50, 10); 
  Beacon[] beacons = {b0, b1, b2}; 

  public Mapper(int map_length, int map_width, double target_x,
    double target_y, Beacon b0, Beacon b1, Beacon b2) {
        //setSize(500, 500);
    	//pause(10);
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

    	// Adjust coordinates for offsets.
      JFrame frame = new JFrame ();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(canvas);
      frame.setVisible(true);
      frame.setSize(500 + 2*offset, 500 + 2*offset); 
      canvas.setSize(500 + 2*offset, 500 + 2*offset);   
      GImage background = new GImage("office.jpeg", offset, offset); 
      background.setSize(500, 500); 
      canvas.add(background);

      target = new GOval(target_x - target_size/2 + offset, target_y - target_size/2 + offset, target_size, target_size);
      target.setFilled(true);
      target.setColor(Color.GREEN);
      canvas.add(target);   
      x = target_x; 
      y = target_y; 

      t.start();
      addKeyListener(this);
      this.setFocusable(true);
      setFocusTraversalKeysEnabled(false);  

    }

    public void addLines(double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2){
      line0 = new GLine(b0.get_x() + offset, b0.get_y() + offset, target_x + offset, target_y + offset);
      line0.setColor(Color.RED);
      canvas.add(line0); 

      line1 = new GLine(b1.get_x() + offset, b1.get_y() + offset, target_x + offset, target_y + offset);
      line1.setColor(Color.ORANGE);
      canvas.add(line1); 

      line2 = new GLine(b2.get_x() + offset, b2.get_y() + offset, target_x + offset, target_y + offset);
      line2.setColor(Color.BLUE);
      canvas.add(line2); 
    }

    public void addBeacons(double target_x,double target_y, Beacon b0, Beacon b1, Beacon b2){        
      beacon_0 = new GOval(b0.get_x() - beacon_size/2 + offset, b0.get_y() - beacon_size/2 + offset, beacon_size, beacon_size);
      beacon_0.setFilled(true);
      beacon_0.setColor(Color.RED);
      canvas.add(beacon_0);

      beacon_1 = new GOval(b1.get_x() - beacon_size/2 + offset, b1.get_y() - beacon_size/2 + offset, beacon_size, beacon_size);
      beacon_1.setFilled(true);
      beacon_1.setColor(Color.ORANGE);
      canvas.add(beacon_1);

      beacon_2 = new GOval(b2.get_x() - beacon_size/2 + offset, b2.get_y() - beacon_size/2 + offset, beacon_size, beacon_size);
      beacon_2.setFilled(true);
      beacon_2.setColor(Color.BLUE);
      canvas.add(beacon_2);
      beacons[0] = b0; 
      beacons[1] = b1; 
      beacons[2] = b2; 
    }

    public void addCircles(double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2){
      beacon_0r = new GOval(b0.get_x() - b0.get_radius() + offset, b0.get_y() - b0.get_radius() + offset, b0.get_radius()*2, b0.get_radius()*2);
      beacon_0r.setFilled(false);
      beacon_0r.setColor(Color.RED);
      canvas.add(beacon_0r);

      beacon_1r = new GOval(b1.get_x() - b1.get_radius() + offset, b1.get_y() - b1.get_radius() + offset, b1.get_radius()*2, b1.get_radius()*2);
      beacon_1r.setFilled(false);
      beacon_1r.setColor(Color.ORANGE);
      canvas.add(beacon_1r);

      beacon_2r = new GOval(b2.get_x() - b2.get_radius() + offset, b2.get_y() - b2.get_radius() + offset, b2.get_radius()*2, b2.get_radius()*2);
      beacon_2r.setFilled(false);
      beacon_2r.setColor(Color.BLUE);
      canvas.add(beacon_2r);
    }

    public void keyPressed(KeyEvent e) {
      int code = e.getKeyCode();
      if (code == KeyEvent.VK_DOWN) {
        y+=5; 
        set_radii(x,y); 
        updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
      }
      if (code == KeyEvent.VK_UP) {
        y-=5; 
        set_radii(x,y);
        updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
      }
      if (code == KeyEvent.VK_LEFT) {
        x-=5; 
        set_radii(x,y);
        updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
      }
      if (code == KeyEvent.VK_RIGHT) {
        x+=5; 
        set_radii(x,y);
        updateBoard(x, y, beacons[0], beacons[1], beacons[2]);
      }
    }

    public void set_radii(double x, double y){
      beacons[0].set_radius(Math.sqrt(   Math.pow(   beacons[0].get_x() - x, 2  )   +   Math.pow(   beacons[0].get_y() - y, 2  )));
      beacons[1].set_radius(Math.sqrt(   Math.pow(   beacons[1].get_x() - x, 2  )   +   Math.pow(   beacons[1].get_y() - y, 2  )));
      beacons[2].set_radius(Math.sqrt(   Math.pow(   beacons[2].get_x() - x, 2  )   +   Math.pow(   beacons[2].get_y() - y, 2  )));
    }


    public void updateBoard(double target_x, double target_y, Beacon b0, Beacon b1, Beacon b2) {
      target.sendToFront(); 
      target.setLocation(target_x - beacon_size/2, target_y - beacon_size/2);

      //line0.setEndPoint(target_x, target_y); 
      beacon_0r.setLocation(b0.get_x() - b0.get_radius() + offset, b0.get_y() - b0.get_radius() + offset);
      beacon_0r.setSize(b0.get_radius()*2, b0.get_radius()*2);

      //line1.setEndPoint(target_x, target_y); 
      beacon_1r.setLocation(b1.get_x() - b1.get_radius() + offset, b1.get_y() - b1.get_radius() + offset);
      beacon_1r.setSize(b1.get_radius()*2, b1.get_radius()*2);
      
      //line2.setEndPoint(target_x, target_y); 
      beacon_2r.setLocation(b2.get_x() - b2.get_radius() + offset, b2.get_y() - b2.get_radius() + offset); 
      beacon_2r.setSize(b2.get_radius()*2, b2.get_radius()*2); 

    }
  } 
