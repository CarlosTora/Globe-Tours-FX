package sample;

import data.*;
import files.FileUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

/**
 * In this class, the entire program and everything related to JavaFX is managed and executed
 */
public class Controller implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private Button bttConfirm;
    @FXML
    private DatePicker dpDeparture;
    @FXML
    private DatePicker dpArrival;
    @FXML
    private CheckBox cb_options;
    @FXML
    private Label txt_departure;
    @FXML
    private Label txt_arrival;
    @FXML
    private Label txt_menu;
    @FXML
    private AnchorPane code_user;
    @FXML
    private Button btn_LogIn;
    @FXML
    private Label txt_welcome;
    @FXML
    private ListView<String> ListElements;
    @FXML
    private TextField txtUser;
    @FXML
    private Button bttHotel;
    @FXML
    private Button bttFlight;
    @FXML
    private Button bttGuide;
    @FXML
    private Button bttFull;
    @FXML
    private Button bttEnter;
    @FXML
    private Label txtOption;


    private final FileUtils file = new FileUtils();
    private String codeUser;
    private ArrayList<Flight> listFlight;
    private ArrayList<Flight> reserveFlight;

    private ArrayList<TourGuide> listTourGuide;
    private ArrayList<TourGuide> listReserveTourGuide;
    private ArrayList<Hotel> listHotel;
    private ArrayList<Hotel> listReserveHotel;
    private ArrayList<User> listUser;
    private Set<String> setFlight;
    private Set<String> setHotel;
    private Set<String> setGuide;
    private ArrayList<User> listUsers;
    private String origen;
    private String destination;
    private String departure;
    private String arrival;
    private String stars;
    private String name;
    private String tour;
    private String language;
    private double price;

    /**
     * This function is in charge of initializing all the data and lists necessary for the operation.
     * Color the menu buttons gray (inactive) and hide the fields not yet allowed
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bttHotel.setStyle("-fx-background-color: #dadada");
        bttFlight.setStyle("-fx-background-color: #dadada");
        bttGuide.setStyle("-fx-background-color: #dadada");
        bttFull.setStyle("-fx-background-color: #dadada");
        txt_menu.setText("You need to be logged");
        dpDeparture.setVisible(false);
        dpArrival.setVisible(false);
        cb_options.setVisible(false);
        bttConfirm.setVisible(false);
        bttHotel.setVisible(false);
        bttFlight.setVisible(false);
        bttGuide.setVisible(false);
        bttFull.setVisible(false);

        listFlight = file.loadFlight();
        listHotel = file.loadHotel();
        listTourGuide = file.loadTourGuide();
        listUsers = file.loadUser();
        reserveFlight = file.loadReserveFlight();
        listReserveHotel = file.loadReserveHotel();
        listReserveTourGuide = file.loadReserveGuide();

        setHotel = new HashSet();
        setFlight = new HashSet();
        setGuide = new HashSet();
    }

    /**
     * Changes the color of the HOTEL button when it is selected
     */
    public void bttHotelPushed() {

        if (bttHotel.getStyle().equals("-fx-background-color: #dadada")) {

            bttHotel.setStyle("-fx-background-color: #4ce45e");
            bttFlight.setStyle("-fx-background-color: #dadada");
            bttGuide.setStyle("-fx-background-color: #dadada");
            bttFull.setStyle("-fx-background-color: #dadada");

        } else  {
            bttHotel.setStyle("-fx-background-color: #dadada");
        }
    }

    /**
     * Changes the color of the FLIGHT button when it is selected
     */
    public void bttFlyPushed() {

        if (bttFlight.getStyle().equals("-fx-background-color: #dadada")) {

            bttFlight.setStyle("-fx-background-color: #4ce45e");
            bttHotel.setStyle("-fx-background-color: #dadada");
            bttGuide.setStyle("-fx-background-color: #dadada");
            bttFull.setStyle("-fx-background-color: #dadada");
        } else  {
            bttFlight.setStyle("-fx-background-color: #dadada");
        }
    }

    /**
     * Changes the color of the GUIDE button when it is selected
     */
    public void bttGuidePushed() {

        if (bttGuide.getStyle().equals("-fx-background-color: #dadada")) {

            bttGuide.setStyle("-fx-background-color: #4ce45e");
            bttHotel.setStyle("-fx-background-color: #dadada");
            bttFlight.setStyle("-fx-background-color: #dadada");
            bttFull.setStyle("-fx-background-color: #dadada");
        } else  {
            bttGuide.setStyle("-fx-background-color: #dadada");
        }
    }

    /**
     * Changes the color of the FULL TRIP button when it is selected
     */
    public void bttAllPushed() {

        if (bttFull.getStyle().equals("-fx-background-color: #dadada")) {

            bttFull.setStyle("-fx-background-color: #4ce45e");
            bttHotel.setStyle("-fx-background-color: #dadada");
            bttFlight.setStyle("-fx-background-color: #dadada");
            bttGuide.setStyle("-fx-background-color: #dadada");
        } else  {
            bttFull.setStyle("-fx-background-color: #dadada");
        }
    }

    /**
     * This function controls the ENTER button, to access the menu option that is selected
     */
    public void bttEnter() {
        if (bttHotel.getStyle().equals("-fx-background-color: #4ce45e")) {
            reserveHotel(0);
        }
        else if (bttFlight.getStyle().equals("-fx-background-color: #4ce45e")) {
            reserveFlight(0);
        }
        else if (bttGuide.getStyle().equals("-fx-background-color: #4ce45e")) {
            reserveGuide(0);
        }
        else if (bttFull.getStyle().equals("-fx-background-color: #4ce45e")) {
            reserveFlight(1);

        }
    }

    /**
     * Function to reserve a FLIGHT
     * @param option if the option is 0 it means that it is a simple reservation, if it is 1 it is a complete reservation
     */
    private void reserveFlight(int option) {
        clearWindow();

        txtOption.setText("Choose origin airport");

        // Pass the list to a set to avoid duplicates
        for (Flight flight : listFlight) {
            setFlight.add(flight.getOriginAirport());
        }
        for (String airport : setFlight) {
            ListElements.getItems().add(airport);
        }

        // Event to control the click on the ListView
        ListElements.setOnMouseClicked(mouseEvent -> {
            if (ListElements.getSelectionModel().getSelectedItem() != null) {
                if(origen == null) {
                    origen = ListElements.getSelectionModel().getSelectedItem();
                }
                else{
                    destination = ListElements.getSelectionModel().getSelectedItem();
                }
                bttConfirm.setVisible(true);
            }
        });

        date("fight");

        if (option == 0)
            buttonConfirm("flight",0);
        else
            buttonConfirm("flight",1);
    }

    /**
     * Function to reserve a HOTEL
     * @param option if the option is 0 it means that it is a simple reservation, if it is 1 it is a complete reservation
     */
    private void reserveHotel(int option) {
        clearWindow();

        txtOption.setText("Choose a city");
        // Pass the list to a set to avoid duplicates
        for (Hotel hotel : listHotel) {
            setHotel.add(hotel.getCity());
        }
        for (String city : setHotel) {
            ListElements.getItems().add(city);
        }

        // Event to control the click on the ListView
        ListElements.setOnMouseClicked(mouseEvent -> {

            if (ListElements.getSelectionModel().getSelectedItem() != null) {
                if(origen == null)
                    origen = ListElements.getSelectionModel().getSelectedItem();
                else if (stars == null) {
                    stars = ListElements.getSelectionModel().getSelectedItem();
                }
                else if (name == null ) {
                    name = ListElements.getSelectionModel().getSelectedItem();
                    System.out.println(name);
                }
                bttConfirm.setVisible(true);
            }
        });

        date("hotel");

        if (option == 0)
            buttonConfirm("hotel",0);
        else
            buttonConfirm("hotel",1);
    }

    /**
     * Function to reserve a GUIDE
     * @param option if the option is 0 it means that it is a simple reservation, if it is 1 it is a complete reservation
     */
    private void reserveGuide(int option) {
        clearWindow();
        txtOption.setText("Choose a city");
        // Pass the list to a set to avoid duplicates
        for (TourGuide guide : listTourGuide) {
            setGuide.add(guide.getCity());
        }
        for (String city : setGuide) {
            ListElements.getItems().add(city);
        }

        // Event to control the click on the ListView
        ListElements.setOnMouseClicked(mouseEvent -> {
            if (ListElements.getSelectionModel().getSelectedItem() != null) {
                if(origen == null)
                    origen = ListElements.getSelectionModel().getSelectedItem();

                else if (tour == null)
                    tour = ListElements.getSelectionModel().getSelectedItem();

                bttConfirm.setVisible(true);
            }
        });

        // Date for a TOUR
        dpDeparture.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

        dpDeparture.valueProperty().addListener((ov, oldValue, newValue) -> {
            departure = String.valueOf(dpDeparture.getValue());
            bttConfirm.setVisible(true);
        });

        if (option == 0)
            buttonConfirm("tour",0);
        else
            buttonConfirm("tour",1);
    }

    /**
     * Function to control all the events of the CONFIRM button
     * @param option if the option is 0 it means that it is a simple reservation, if it is 1 it is a complete reservation
     * @param mode represents reverse mode in action
     */
    private void buttonConfirm(String option, int mode) {

        bttConfirm.setOnMouseClicked(mouseEvent -> {
            if(origen != null) {
                ListElements.getItems().clear();
                bttConfirm.setVisible(false);

                switch (option) {

                    // CASE FLIGHT
                    case "flight":
                        ListElements.getItems().clear();
                        bttConfirm.setVisible(false);

                        // Shows available destinations for the origin airport
                        txtOption.setText("Choose destination airport");
                        for (Flight flight : listFlight) {
                            if (flight.getOriginAirport().equalsIgnoreCase(origen)) {
                                ListElements.getItems().add(flight.getDestinationAirport());
                            }
                        }
                        // When the destination is selected, it shows the calendar
                        if ( destination != null) {

                            ListElements.getItems().clear();

                            txtOption.setText("Your Flight");
                            ListElements.getItems().add("Origen: "+origen);
                            ListElements.getItems().add("Destination: "+destination);
                            txt_departure.setText("Departure");
                            dpDeparture.setVisible(true);
                            bttConfirm.setVisible(false);
                        }
                        // Once the round trip has been selected, a flight confirmation window appears
                        if (arrival != null && departure != null ) {
                            arrival = String.valueOf(dpArrival.getValue());

                            for (Flight flight : listFlight) {
                                if(flight.getOriginAirport().equals(origen) && flight.getDestinationAirport().equals(destination)) {

                                    Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                                    dialog.setTitle("-- CONFIRM FLIGHT --");
                                    dialog.setHeaderText("· "+origen+" --> "+destination+"" +
                                            "\n· "+departure+" to "+arrival+"\n· Business --> "+(cb_options.isSelected()?"YES":"NO")+
                                            "\n· Price: "+flight.getPrice()+"€");
                                    dialog.setContentText("Do you want to confirm the reservation?");
                                    Optional<ButtonType> result = dialog.showAndWait();
                                    if (result.get() == ButtonType.OK) {

                                        Flight f = new Flight(txtUser.getText(),origen,destination,departure,
                                                arrival,cb_options.isSelected(),flight.getPrice());
                                        reserveFlight.add(f);

                                        FileUtils.saveReserveFlight(reserveFlight);
                                    }
                                    clearWindow();
                                    // if the mode is 1, it means that it is a complete reversal
                                    // and must continue with the other reserves
                                    if(mode == 1)
                                        reserveHotel(1);
                                }
                            }
                        }
                        break;

                    // CASE HOTEL
                    case "hotel":
                        txtOption.setText("Choose stars");
                        boolean foundHotel = false;

                        // Print stars
                        for (int i = 1; i < 6; i++) {
                            ListElements.getItems().add(String.valueOf(i));
                        }
                        // Show the hotels in that city and with those stars
                        if (stars != null) {
                            txtOption.setText("Choose a hotel");
                            ListElements.getItems().clear();
                            for ( Hotel hotel : listHotel) {
                                if(hotel.getCity().equals(origen) && hotel.getStars() == Integer.parseInt(stars)) {
                                    ListElements.getItems().add(hotel.getName());
                                    foundHotel = true;
                                }
                            }
                            // If there are no hotels in that city with these characteristics
                            if (!foundHotel) {
                                Alert dialog = new Alert(Alert.AlertType.ERROR);
                                dialog.setTitle("Error");
                                dialog.setHeaderText("There is no hotel in "+origen+" with these characteristics");
                                dialog.setContentText("Try again");
                                dialog.showAndWait();
                                Optional<ButtonType> result = dialog.showAndWait();
                                if (result.get() == ButtonType.OK) {
                                    clearWindow();
                                    if (mode == 0)
                                        reserveHotel(0);
                                    else
                                        reserveHotel(1);
                                }
                            }
                        }
                        // When you select the hotel, show the data and enable the calendar
                        if (name!= null) {
                            ListElements.getItems().clear();
                            txtOption.setText("Your Hotel");
                            ListElements.getItems().add("City: "+origen);
                            ListElements.getItems().add("Hotel: "+name);
                            ListElements.getItems().add("Stars: "+stars);
                            txt_departure.setText("Departure");
                            dpDeparture.setVisible(true);
                            bttConfirm.setVisible(false);
                        }
                        // Once the check-in and check-out date has been selected, a hotel confirmation window appears.
                        if (departure != null ) {
                            arrival = String.valueOf(dpArrival.getValue());

                            for (Hotel hotel : listHotel) {
                                if (hotel.getCity().equals(origen) && hotel.getStars() == Integer.parseInt(stars)) {

                                    Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                                    dialog.setTitle("-- CONFIRM HOTEL --");
                                    dialog.setHeaderText("· "+name +" ("+ origen +")"+
                                            "\n· " + departure + " to " + arrival + "\n· Pets --> " + (cb_options.isSelected() ? "YES" : "NO") +
                                            "\n· Price: " + hotel.getPrice() + "€");
                                    dialog.setContentText("Do you want to confirm the reservation?");
                                    Optional<ButtonType> result = dialog.showAndWait();
                                    if (result.get() == ButtonType.OK) {

                                        Hotel h = new Hotel(codeUser, origen, name, hotel.getPrice(),
                                                departure, arrival, Integer.parseInt(stars), cb_options.isSelected());

                                        listReserveHotel.add(h);

                                        FileUtils.saveReserveHotel(listReserveHotel);
                                    }
                                    clearWindow();
                                    // if the mode is 1, it means that it is a complete reversal
                                    // and must continue with the other reserves
                                    if(mode == 1)
                                        reserveGuide(1);
                                }
                            }
                        }
                        break;

                    // CASE TOUR
                    case "tour": txtOption.setText("Choose tour");

                        ListElements.getItems().clear();
                        // Show available tours for that city
                        for ( TourGuide guide : listTourGuide) {
                            if(guide.getCity().equals(origen)) {
                                ListElements.getItems().add(guide.getMonuments());
                            }
                        }
                        // Once the tour is selected, it extracts the data, shows it and enables the calendar
                        if (tour!= null) {
                            for ( TourGuide guide : listTourGuide) {

                                if(guide.getCity().equals(origen) && guide.getMonuments().equals(tour)) {
                                    name = guide.getName();
                                    language = guide.getLanguage();
                                    price = guide.getPrice();
                                }
                            }

                            ListElements.getItems().clear();
                            txtOption.setText("Your tour");
                            ListElements.getItems().add("Your Guide is: "+name);
                            ListElements.getItems().add("Monument: "+tour);
                            ListElements.getItems().add("Language: "+language);
                            ListElements.getItems().add("Price: "+price+"€");
                            txt_departure.setText("Date");
                            dpDeparture.setVisible(true);

                            bttConfirm.setVisible(false);
                        }
                        // Once the date is selected, the tour confirmation sale appears
                        if (departure != null ) {

                            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                            dialog.setTitle("-- CONFIRM TOUR GUIDE --");
                            dialog.setHeaderText("· "+tour+" ("+origen+"). \n"+name+" - "+language+" --> "+price+"€\nDate: "+departure);
                            dialog.setContentText("Do you want to confirm the reservation?");
                            Optional<ButtonType> result = dialog.showAndWait();
                            if (result.get() == ButtonType.OK) {

                                TourGuide t = new TourGuide(codeUser,origen,name,tour,departure,language,price);
                                listReserveTourGuide.add(t);
                                FileUtils.saveReserveGuide(listReserveTourGuide);
                            }
                            clearWindow();
                        }
                        break;
                }
            }
        });
    }

    /**
     * This function controls everything related to the user's login
     */
    public void btn_login() {
        boolean found = false;
        String name ="";
        // Check if a user with that code exists in the database
        for (User user : listUsers) {
            if (txtUser.getText().equals(user.getCode())) {
                codeUser = user.getCode();
                name = user.getName();
                found = true;
            }
        }
        // If there is a match between the code entered and the code of a user in the database,
        // they are given access to the app
        if (found) {
            bttHotel.setVisible(true);
            bttFlight.setVisible(true);
            bttGuide.setVisible(true);
            bttFull.setVisible(true);
            txt_menu.setText("");
            txt_welcome.setText("Welcome "+name);
            btn_LogIn.setVisible(false);
        }
        // If it does not find a match, it asks the user if they want to access as a guest
        else {
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Error Code User");
            dialog.setHeaderText("");
            dialog.setContentText(txtUser.getText()+": User code not found.\n\nDo you want to enter as a guest?");
            Optional<ButtonType> result = dialog.showAndWait();
            if (result.get() == ButtonType.OK) {

                txtUser.setText("Guest");
                bttHotel.setVisible(true);
                bttFlight.setVisible(true);
                bttGuide.setVisible(true);
                bttFull.setVisible(true);
                txt_menu.setText("");
                txt_welcome.setText("Welcome Guest");
            }
            else {
                txtUser.setText("");
            }
        }
    }

    /**
     * This function controls the reservation calendars and prevents putting a date past the current one
     * @param mode represents reverse mode in action
     */
    private void date(String mode) {
        dpDeparture.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

        dpArrival.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(dpDeparture.getValue()) < 0 );
            }
        });

        dpDeparture.valueProperty().addListener((ov, oldValue, newValue) -> {
            departure = String.valueOf(dpDeparture.getValue());
            if(departure != null) {
                txt_arrival.setText("Arrival");
                dpArrival.setVisible(true);
                cb_options.setVisible(true);
                if(mode.equals("hotel"))
                    cb_options.setText("Pets");
                else
                    cb_options.setText("Business");
                dpArrival.setValue(LocalDate.parse(departure));
            }
        });

        dpArrival.setOnMouseClicked(mouseEvent -> {
            arrival = String.valueOf(dpArrival.getValue());
            if(!arrival.equals("null")){
                bttConfirm.setVisible(true);
            }
        });
    }

    /**
     * Function to reset the options and texts
     */
    private void clearWindow() {
        bttHotel.setStyle("-fx-background-color: #dadada");
        bttFlight.setStyle("-fx-background-color: #dadada");
        bttGuide.setStyle("-fx-background-color: #dadada");
        bttFull.setStyle("-fx-background-color: #dadada");
        ListElements.getItems().clear();
        txt_departure.setText("");
        txt_arrival.setText("");
        txtOption.setText("");
        dpDeparture.setVisible(false);
        dpArrival.setVisible(false);
        cb_options.setVisible(false);
        bttConfirm.setVisible(false);
        origen = null;
        destination = null;
        departure = null;
        arrival = null;
        stars = null;
        name = null;
        tour = null;
        language = null;
    }
}
