package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.flight.Booking;
import ie.lyit.flight.Date;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Name;
import ie.lyit.flight.Passenger;
import ie.lyit.flight.Time;

public class BookingTester {

	public static void main(String[] args) {
		// 2 ArrayList of type Passenger called passengers
		ArrayList<Passenger> firstPassengers = new ArrayList<Passenger>();
		ArrayList<Passenger> secondPassengers = new ArrayList<Passenger>();

			//make sure you change my name lol
	    Name n1 = new Name("Mr","Martin","Benchi");
	    Passenger p1 = new Passenger(n1,new Date(11,4,1999),2,true);	

	    Name n2 = new Name("Mrs","Maria","Boyle");
	    Passenger p2 = new Passenger(n2,new Date(15,6,1980),1,true);
	    
	    firstPassengers.add(p1);
	    firstPassengers.add(p2);
	    secondPassengers.add(new Passenger(new Name("Ms","Slim","Nana"),
	    		                     new Date(3,5,2016),0,true)); 

	    
	    System.out.println(firstPassengers);
	    System.out.println(secondPassengers);


	    Flight outboundFlight = new Flight("BR215","Milano","Derry",new Date(25,12,2018),new Time(12,40),16.99);
        System.out.println(outboundFlight);
        
        Flight outboundFlightTest = new Flight("BR215","Milano","Derry",new Date(25,12,2018),new Time(12,40),16.99);
        
	    Flight inboundFlight = new Flight("BR418","Dublin","Amstadam",new Date(30,12,2018),new Time(10,15),24.99);
        System.out.println(inboundFlight);
        
		if(outboundFlight.equals(inboundFlight))
			System.out.println(outboundFlight + " is the same flight as "+ inboundFlight);
		else
			System.out.println(outboundFlight + " is not the same flight as "+ inboundFlight);
		
		if(outboundFlight.equals(outboundFlightTest))
			System.out.println(outboundFlight + " is the same flight as "+ outboundFlightTest);
		else
			System.out.println(outboundFlight + " is not the same flight as "+ outboundFlightTest);
		
		Booking firstBooking = new Booking(outboundFlight, inboundFlight, firstPassengers);
		Booking secondBooking = new Booking(outboundFlightTest, inboundFlight, secondPassengers);
		Booking thirdBooking = new Booking(outboundFlightTest, secondPassengers);

	    System.out.println(firstBooking);
	    System.out.println(secondBooking);
	    System.out.println(thirdBooking);
		
	    System.out.println(firstBooking.findPassenger(p1));
	    System.out.println(secondBooking.findPassenger(new Passenger(new Name("Ms","Slim","Nana"),
                new Date(3,5,2016),0,true)));
	    
	    for (int i = 1; i < 11; i++)
	    	secondPassengers.add(p2);
	    
	    System.out.println(secondPassengers.size());
	    
		//Booking elevenPassengersBooking = new Booking(outboundFlightTest, secondPassengers);
		
		//Flight emptyFlight = new Flight();
		
		//Booking emptyOutboundBooking = new Booking(emptyFlight, firstPassengers);
	   
	}
}
