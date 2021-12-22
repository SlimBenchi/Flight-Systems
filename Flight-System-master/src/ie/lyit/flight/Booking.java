package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {

	protected Flight outbound;
	protected Flight inbound;
	protected ArrayList<Passenger> passengers;
	protected double totalPrice;
	protected int bookingNo;
	private static int nextUniqueBookingNumber = 10000;

	//////////////////////////////////////////////
	//According to the requirements of the assignment
	//the user shouldn't be allowed to make a booking with
	//at least one passenger or a out bound flight
	//so i don't think there is a requirement for a default constructor
	//but I am not so sure ......
	//I decided to add it but also comment it out
	///////////////////////////////////////////////


	/*
	public Booking(){
		this.bookingNo = nextUniqueBookingNumber++;
		this.outbound = new Flight();
		this.inbound = new Flight();
		this.passengers = new ArrayList<Passenger>();
		this.totalPrice = 0.0;
	}*/

	//the constructor.... This takes out bound flight and the arrayList of passengers
	//this also check if the list of passengers falls the required limit
	//also check if there is an out bound flight
	//It throws IllegalArgumentException error when it doesn't 
	//initialises the instance variable if the check passes
	public Booking(Flight outbound, ArrayList<Passenger> passengers){
		if (passengers.size() < 1 || passengers.size() > 9)
			throw new IllegalArgumentException("The number of passengere should be > 1 or <10");		

		if (outbound == null)
			throw new IllegalArgumentException("The outbound flight can't be empty");		

		//there is no in bound flight so that will be initialised to None
		//The bookingNO will be initialised to a unique int value which increases each time an object is created
		//the calculatePrice is called and assigned to to totalPrice 
		this.bookingNo = nextUniqueBookingNumber++;
		this.outbound = outbound;
		this.inbound = null;
		this.passengers = passengers;
		this.totalPrice = calculatePrice();
	}

	//the constructor 2nd.... This takes out bound flight, in bound flight and the arrayList of passengers
	//this also check if the list of passengers falls the required limit
	//also check if there is an out bound flight
	//It throws IllegalArgumentException error when it doesn't 
	//initialises the instance variable if the check passes
	public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers){
		if (passengers.size() < 1 || passengers.size() > 9)
			throw new IllegalArgumentException("The number of passengere should be > 1 or <10");		

		if (outbound == null)
			throw new IllegalArgumentException("The outbound flight can't be empty");		

		//initialise the instance variables
		this.bookingNo = nextUniqueBookingNumber++;
		this.outbound = outbound;
		this.inbound = inbound;
		this.passengers = passengers;
		this.totalPrice = calculatePrice();
	}


	//setters 
	//this setter method takes in a flight object 
	//check if the object is not null
	//throws IllegalArgumentException error if it is null
	//else initialises it to the outbound variable
	public void setOutboundFlight(Flight outbound) {
		if (outbound == null)
			throw new IllegalArgumentException("The outbound flight can't be empty");		

		this.outbound = outbound;
	}

	// setter methods
	//this setter takes in the in bound flight an initilises it to the inbound variable
	public void setInboundFlight(Flight inbound) {
		this.inbound = inbound;
	}

	//this setter method takes in an arrayList of passenger
	//it first checks if the number of passengers is more than 0 and also not more than 9
	//it throws IllegalArgumentException if it does
	//else it assigns the arrayList of passengers to the passenger variable
	public void setPassengers(ArrayList<Passenger> passengers) {

		if (passengers.size() < 1 || passengers.size() > 9)
			throw new IllegalArgumentException("The number of passengere should be > 1 and <10");		

		this.passengers = passengers;
	}

	//getter methods
	//this method returns the outbound flight object
	public Flight getOutboundFlight() {

		return this.outbound;
	}

	//this getter method returns the inbound flight object
	public Flight getInboundFlight() {

		return this.inbound;
	}

	//this getter method returns the arraylist of passengers 
	public ArrayList<Passenger> getPassengers(){
		return this.passengers;
	}

	//this method takes in a passenger object 
	//iterate through the arrayList of passengers 
	//returns true if the passenger object is in the arrayList
	public boolean findPassenger(Object passengerObject) {
		boolean isPassengerFlag = false;

		if (passengerObject instanceof Passenger)
			for(Passenger tmpPassengers : passengers)
				if (tmpPassengers.equals(passengerObject))
					isPassengerFlag = true;

		return isPassengerFlag;
	}
	
	//this method calculates the total price of the booking
	//it multiplies the number of passengers by the price of the booking
	//Flight.getPrice returns the price of the flight
	//the if clause is used to check if there is an inbound 
	//add the price of the in bound if it isnt null
	public double calculatePrice() {

		double total = 0;
		int totalNumberOfPassengers = this.passengers.size() ;
		double outboundPrice = outbound.getPrice();

		if (inbound == null)
			total = outboundPrice * totalNumberOfPassengers;
		else
		{
			double inboundPrice = inbound.getPrice();
			total = (outboundPrice + inboundPrice) * totalNumberOfPassengers;}

		return total;
	}
	
	//the to string 
	//this creates a string st.... which holds the flight inbound
	//st is assigned to "No Return Flight Available" if there is no in bound flight
	//else set st to the inbound object
	public String toString() {

		String str;
		String st;

		if (inbound == null)
			st = "No Return Flight Available"; 
		else
			st = String.valueOf(this.inbound);


		str = "\nBooking Ref: "+this.bookingNo + 
				"\nOutbound Flight: "+this.outbound +
				"\nReturn Flight: "+ st +
				"\nPassengers: "+this.passengers +
				"\nTotal Price: "+this.totalPrice + " Euro";

		return str;
	}

	//the equals method
	//it takes in an object ... check if the object is a flight object 
	//then compares the 2 objects booking number
	//returns true if the booking numbers are the same
	public boolean equals(Object object) {
		Booking bookingObject;
		if (object instanceof Booking)
			bookingObject = (Booking)object;
		else
			return false;

		return this.bookingNo == (bookingObject.bookingNo);	
	}

}
