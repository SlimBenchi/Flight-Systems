package ie.lyit.flight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	
	//create a booking object
	private Booking booking;
	
	//create the arrayList of passenger to test the methods
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	//create another arrayList of passenger... this will be empty
	ArrayList<Passenger> emptyPassengers = new ArrayList<Passenger>();
	
	//create arrayList which will be populated with 10 passengers
	ArrayList<Passenger> tenpass = new ArrayList<Passenger>();
	
	//create 2 flight objects ... one for outbound and the other for inbound
    Flight outboundFlight = new Flight("BR215","Milano","Derry",new Date(25,12,2018),new Time(1,40),16.99);
    Flight inboundFlight = new Flight("BR418","Dublin","Amstadam",new Date(30,12,2018),new Time(10,15),24.99);
    
    //create another flight object but this time no flight is added
    Flight emptyOutboundFlight = new Flight();
    
    //create a passenger object to populate the arrayList
    Passenger p1 = new Passenger(new Name("Ms","Slim","Nana"),new Date(15,6,1980),1,true);
    
    
    @Before
	public void setUp() throws Exception {
    	//add a passenger to the passenger arraylist before setup
    	passengers.add(p1);
    	
    	//initialise the booking with flights and passengers
		booking = new Booking(outboundFlight, inboundFlight, passengers);
		
		//populate tenpass with the passenger p1 * 10
		for (int i = 1; i < 11; i++)
	    	tenpass.add(p1);
	}

    //test the constructor
	@Test
	public void testBooking() {
		//use the assertEquals methods to check the input parameters of the booking constructor
		assertEquals(outboundFlight, booking.getOutboundFlight());
		assertEquals(inboundFlight, booking.getInboundFlight());
		assertEquals(passengers, booking.getPassengers());
	}
	
	//check the setPassengers function using the assertEquals function
	//with the populated arrayList p1
	@Test
	public void testBookingFlightArrayListOfPassenger() {
		booking.setPassengers(passengers);
		
		assertEquals(passengers, booking.getPassengers());
	}
	
	//check the setPassengers function using the assertEquals function
	//with the empty arrayList
	//expect an IllegalArgumentException to be thrown
	@Test(expected = IllegalArgumentException.class)
	public void testBookingFlightEmptyArrayListOfPassenger() {
		booking.setPassengers(emptyPassengers);
		
		assertEquals(emptyPassengers, booking.getPassengers());	
	}
	
	//check the setPassengers function using the assertEquals function
	//with the empty arrayList
	//expect an IllegalArgumentException to be thrown
	@Test(expected = IllegalArgumentException.class)
	public void testBookingTenPassengersArrayListOfPassenger() {
		
		booking.setPassengers(tenpass);
		
		assertEquals(tenpass, booking.getPassengers());	
	}


	@Test
	public void testSetOutboundFlight() {
		booking.setOutboundFlight(outboundFlight);
		
		assertEquals(outboundFlight, booking.getOutboundFlight());
	}
	
	@Test
	public void testSetEmptyOutboundFlight() {
		booking.setOutboundFlight(emptyOutboundFlight);
		
		assertEquals(emptyOutboundFlight, booking.getOutboundFlight());
	}

	@Test
	public void testSetInboundFlight() {
		booking.setInboundFlight(inboundFlight);
		
		assertEquals(inboundFlight, booking.getInboundFlight());
	}

	@Test
	public void testSetPassengers() {
		booking.setPassengers(passengers);
		
		assertEquals(passengers, booking.getPassengers());	}


	
	@Test
	public void testFindPassenger() {
		booking.findPassenger(p1);
		
		assertTrue( booking.findPassenger(p1) == true);
	}
	
	
	@Test
	public void testCalculatePrice() {
		
		assertTrue( booking.calculatePrice() == 41.98);
	}
}
