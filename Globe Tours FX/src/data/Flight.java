package data;

/**
 * This class handles flights.
 * Either to add a FLIGHT in the SYSTEM or to create a FLIGHT RESERVATION.
 */
public class Flight extends Products implements Comparable<Flight>{

    protected String codeUser;
    protected String originAirport;
    protected String destinationAirport;
    protected boolean business;

    /**
     * Constructor to add a new FLIGHT RESERVATION in a system
     * @param codeUser code of the user who reserves
     * @param originAirport departure airport
     * @param destinationAirport destination airport
     * @param departure departure date
     * @param arrival return date
     * @param business bool if you reserve in business
     * @param price flight price
     */
    public Flight(String codeUser,String originAirport,String destinationAirport,
                  String departure,String arrival,boolean business,double price ) {

        this.codeUser = codeUser;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departure = departure;
        this.arrival = arrival;
        this.business = business;
        this.price = price;
    }

    /**
     * Constructor to add a new FLIGHT in a system
     * @param originAirport departure airport
     * @param destinationAirport destination airport
     * @param price flight price
     */
    public Flight(String originAirport, String destinationAirport,double price) {

        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.price = price;
    }

    /**
     * Get Code User
     * @return code user
     */
    public String getCodeUser() {return codeUser;}

    /**
     * Set Code User
     * @param codeUser to change the user code of a reservation
     */
    public void setCodeUser(String codeUser) {this.codeUser = codeUser;}

    /**
     * Get Origin Airport
     * @return originAirport
     */
    public String getOriginAirport() {return originAirport;}

    /**
     * Set Origin Airport
     * @param originAirport to change the origin airport of a flight
     */
    public void setOriginAirport(String originAirport) {this.originAirport = originAirport;}

    /**
     * Get Destination Airport
     * @return destinationAirport
     */
    public String getDestinationAirport() {return destinationAirport;}

    /**
     * Set Destination Airport
     * @param destinationAirport to change the destination airport of a flight
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * Get Business
     * @return business
     */
    public boolean getBusiness() { return business;}

    /**
     * Set Business
     * @param business to change the business bool of a reservation
     */
    public void setBusiness(boolean business) {this.business = business;}

    /**
     * TO ORDER FOR NAME AIRPORT
     * @param b other Flight
     * @return order
     */
    @Override
    public int compareTo(Flight b) {
        return this.getOriginAirport().compareTo(b.getOriginAirport());
    }

    /**
     * Method toString Flight class
     * @return
     */
    @Override
    public String toString() {
        return "-> Info Flight [" +
                " Origin Airport ='" + originAirport + '\'' +
                ", Destination Airport ='" + destinationAirport + '\'' +
                ", Business =" + business +
                ", Price =" + price +
                ", Departure Date ='" + departure + '\'' +
                ", Arrival Date ='" + arrival + '\'' +
                ']';
    }
}
