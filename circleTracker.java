import java.util.Arrays;
import java.io.Console;
import java.util.Scanner;



public class circleTracker {

	public void main(){
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

      	while(true){                                                                                                                                                                                                                                                                                                                                                           
     		 int b0 = 0; 
     		 int b1 = 1; 
     		 int b2 = 2;                                                                                                                                                                                   
     		 double r0 = 100; 
     		 double r1 = 100; 
     		 double r2 = 100;                                                                                                                                                                                                                                                                                                                                                                      
    		 //calculateThreeCircleIntersection(beacons[b0].get_x(), beacons[b0].get_y(), r0, beacons[b1].get_x(), beacons[b1].get_y(), r1, beacons[b2].get_x(), beacons[b2].get_y(), r2);
 		}  
 	}  
}