/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Tester for the Flight class
 * Date: dd/mm/yyy
 * @author Maria Boyle
 * @version 1.0
**/
package ie.lyit.testers;

import ie.lyit.flight.Date;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Time;

public class FlightTester {

	public static void main(String[] args) {
	    Flight fliteA = new Flight("BR215","Derry","Stanstead",new Date(25,12,2018),new Time(12,40),16.99);
        System.out.println(fliteA);

	    Flight fliteB = new Flight("BR418","Stanstead","Derry",new Date(30,12,2018),new Time(10,15),24.99);
        System.out.println(fliteB);
        
		if(fliteA.equals(fliteB))
			System.out.println("These are the same flights.");
		else
			System.out.println("Different Flights.");
	}
}
