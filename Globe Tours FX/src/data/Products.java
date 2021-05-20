package data;

/**
 * Abstract Class of the products offered by the app
 */
public abstract class Products {

    protected double price;
    protected String departure;
    protected String arrival;
    protected String city;

    /**
     * Get City
     * @return
     */
    public String getCity() {return city; }

    /**
     * Set City
     * @param city to change a city
     */
    public void setCity(String city) {this.city = city;}

    /**
     * Get Price
     * @return price
     */
    public double getPrice() {return price;}

    /**
     * Set Price
     * @param price to change a price
     */
    public void setPrice(double price) {this.price = price;}

    /**
     * Get Departure
     * @return departure
     */
    public String getDeparture() {return departure;}

    /**
     * Set Departure
     * @param departure to change a departure
     */
    public void setDeparture(String departure) {this.departure = departure;}

    /**
     * Get Arrival
     * @return arrival
     */
    public String getArrival() {return arrival;}

    /**
     * Set Arrival
     * @param returns to change a arrival
     */
    public void setArrival(String returns) {this.arrival = returns;}

    /**
     * Method toString Product Abstract class
     * @return
     */
    @Override
    public String toString() {
        return "--> Info Product [" +
                "price=" + price +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ']';
    }
}
