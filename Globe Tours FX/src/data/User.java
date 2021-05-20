package data;

/**
 * This class handles USERS.
 */
public class User implements Comparable<User>  {

    protected String code;
    protected String name;
    protected String dni;
    protected int phone;
    protected String country;
    protected String city;

    /**
     * Constructor to User
     * @param code User code
     * @param name User name
     * @param dni User dni
     * @param phone User phone
     * @param country User country
     * @param city User city
     */
    public User(String code, String name, String dni, int phone, String country, String city) {

        this.code = code;
        this.name = name;
        this.dni = dni;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }

    /**
     * Get Code
     * @return code
     */
    public String getCode() {return code;}

    /**
     * Set Code
     * @param code to change a user code
     */
    public void setCode(String code) {this.code = code;}

    /**
     * Get Name
     * @return name
     */
    public String getName() { return name;}

    /**
     * Set Name
     * @param name yo change a user name
     */
    public void setName(String name) {this.name = name;}

    /**
     * Get Dni
     * @return dni
     */
    public String getDni() {return dni;}

    /**
     * Set Dni
     * @param dni to change a user DNI
     */
    public void setDni(String dni) {this.dni = dni;}

    /**
     * Get Phone
     * @return phone
     */
    public int getPhone() {return phone;}

    /**
     * Set Phone
     * @param phone to change a user phone
     */
    public void setPhone(int phone) {this.phone = phone;}

    /**
     * Get Country
     * @return country
     */
    public String getCountry() {return country;}

    /**
     * Set Country
     * @param country to change a user country
     */
    public void setCountry(String country) {this.country = country;}

    /**
     * Get city
     * @return city
     */
    public String getCity() {return city;}

    /**
     * Set city
     * @param city to change a user city
     */
    public void setCity(String city) {this.city = city;}

    /**
     * To order for code user
     * @param b other user
     * @return order
     */

    @Override
    public int compareTo(User b) {
        return this.getCode().compareTo(b.getCode());
    }

    @Override
    public String toString() {
        return "-> Info to " +name+
                ": [ Dni= '" + dni + '\'' +
                ", Phone= " + phone +
                ", Country= '" + country + '\'' +
                ", City= '" + city+" ]";
    }
}
