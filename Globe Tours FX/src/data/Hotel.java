package data;

/**
 * This class handles HOTELS.
 * Either to add a HOTEL in the SYSTEM or to create a HOTEL RESERVATION.
 */
public class Hotel extends Products implements Comparable<Hotel>{

    protected String name;
    protected int stars;
    protected boolean pets;
    protected String codeUser;

    /**
     * Constructor to add a new HOTEL in a system
     * @param city hotel city
     * @param name hotel name
     * @param price price for the hotel
     * @param stars stars for the hotel
     * @param pets bool that allows you to reserve for pets
     */
    public Hotel(String city, String name, double price, int stars, boolean pets) {

        this.city = city;
        this.name = name;
        this.price = price;
        this.stars = stars;
        this.pets = pets;
    }

    /**
     * Constructor to add a new HOTEL RESERVATION in a system
     * @param codeUser code of the user who reserves
     * @param city hotel city
     * @param name hotel name
     * @param price price for the hotel
     * @param departure departure date
     * @param arrival return date
     * @param stars stars for the hotel
     * @param pets bool that allows you to reserve for pets
     */
    public Hotel(String codeUser,String city, String name, double price, String departure, String arrival, int stars, boolean pets) {

        this.codeUser = codeUser;
        this.city = city;
        this.name = name;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.stars = stars;
        this.pets = pets;
    }

    /**
     * Get Stars
     * @returnstars
     */
    public int getStars() {return stars;}

    /**
     * Set Stars
     * @param stars to change the stars of a hotel
     */
    public void setStars(int stars) {this.stars = stars;}

    /**
     * Get Pets
     * @return pets
     */
    public boolean getPets() {return pets;}

    /**
     * Set Pets
     * @param pets to change the pet bool of a reservation
     */
    public void setPets(boolean pets) {this.pets = pets;}

    /**
     * Get Name
     * @return name
     */
    public String getName() {return name;}

    /**
     * Set Name
     * @param name to change the name of a hotel
     */
    public void setName(String name) {this.name = name;}

    /**
     * Get Code User
     * @return
     */
    public String getCodeUser() { return codeUser;}

    /**
     * Set Code User
     * @param codeUser to change the user code of a reservation
     */
    public void setCodeUser(String codeUser) {this.codeUser = codeUser;}

    /**
     * TO ORDER FOR CITY NAME
     * @param b other Hotel
     * @return order
     */
    @Override
    public int compareTo(Hotel b) {
        return this.getCity().compareTo(b.getCity());
    }

    /**
     * Method toString Hotel class
     * @return
     */
    @Override
    public String toString() {
        return "Info Hotel [" +
                " Stars=" + stars +
                ", Pets=" + pets +
                ", Price=" + price +
                ", Departure Date='" + departure + '\'' +
                ", Arrival Date='" + arrival + '\'' +
                ']';
    }
}
