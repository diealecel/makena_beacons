import java.util.Arrays;
import java.io.Console;



public class circleTracker {

	public void main(){
		Console console = System.console();
		double map_length = -1;  
  	  	map_length = console.readLine("Map Length? ");
  	  	 while(map_length < 0){
      	   map_length = console.readLine("Please enter a positivie map length");
    	  }
   
  	   double map_width = -1;  
  	   map_width = console.readLine("Map Width? ");
  	   while(map_width < 0){
  	        map_width = console.readLine("Please enter a positivie map width");
      	}
     	printf("Map length = %d, Map width = %d", map_length, map_width); 
     	Beacon b = new Beacon(1, 1, 1); 
     }
}