package data;

/**
 * This class handles TOUR GUIDES.
 * Either to add a TOUR GUIDE in the SYSTEM or to create a TOUR GUIDE RESERVATION.
 */
public class TourGuide extends Products implements Comparable<TourGuide> {

    protected String codeUser;
    protected String monuments;
    protected String name;
    protected String language;

    /**
     * Constructor to add a new TOUR GUIDE in a system
     * @param city Tour guide city
     * @param name guide's name
     * @param monuments guide monument
     * @param language guide language
     * @param price guide price
     */
    public TourGuide(String  city, String name, String monuments,
                     String language, double price) {

        this.city = city;
        this.price = price;
        this.monuments = monuments;
        this.name = name;
        this.language = language;
    }

    /**
     * Constructor to add a new TOUR GUIDE RESERVATION in a system
     * @param codeUser code of the user who reserves
     * @param city Tour guide city
     * @param name guide's name
     * @param monuments guide monument
     * @param departure date guide
     * @param language guide language
     * @param price guide price
     */
    public TourGuide(String codeUser, String city, String name, String monuments,
                     String departure, String language, double price) {

        this.codeUser = codeUser;
        this.city = city;
        this.name = name;
        this.monuments = monuments;
        this.departure = departure;
        this.language = language;
        this.price = price;
    }

    /**
     * Get Code User
     * @return codeUser
     */
    public String getCodeUser() {
        return codeUser;
    }

    /**
     * Set Code User
     * @param codeUser to change the user code of a reservation
     */
    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    /**
     * Get Monuments
     * @return monuments
     */
    public String getMonuments() {return monuments; }

    /**
     * Set Monuments
     * @param monuments to change the monuments of a guide
     */
    public void setMonuments(String monuments) {this.monuments = monuments;}

    /**
     * Get Name
     * @return name
     */
    public String getName() {return name; }

    /**
     * Set Name
     * @param name to change the name of a guide
     */
    public void setName(String name) {this.name = name;}

    /**
     * Get Language
     * @return language
     */
    public String getLanguage() {return language;}

    /**
     * Set Language
     * @param language to change the language of a guide
     */
    public void setLanguage(String language) {this.language = language;}

    /**
     * TO ORDER FOR CITY GUIDE
     * @param b
     * @return order
     */
    @Override
    public int compareTo(TourGuide b) {
        return this.getCity().compareTo(b.getCity());
    }

    /**
     * Method toString Tour Guide class
     * @return
     */
    @Override
    public String toString() {
        return "--> Info TourGuide [" +
                " Name =" + name +
                ", Excursion Date='" + departure + '\'' +
                ", Monuments='" + monuments + '\'' +
                ", Price='" + price + '\'' +
                ", Language='" + language + '\'' +
                '}';
    }
}
