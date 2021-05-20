package files;

import data.Flight;
import data.Hotel;
import data.TourGuide;
import data.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class handles all .txt files where the app data is stored.
 */
public class FileUtils {

    /**
     * Constructor
     */
    public FileUtils() {
    }

    /**
     * LOAD available FLIGHT data
     * @return listFlight
     */
    public ArrayList<Flight> loadFlight() {
        BufferedReader load = null;
        File c = new File("Flight.txt");
        ArrayList<Flight> listFlight = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("Flight.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String originAirport = part[0];
                    String destinationAirport = part[1];
                    double price = Double.parseDouble(part[2]);

                    Flight C = new Flight(originAirport, destinationAirport,price);
                    listFlight.add(C);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listFlight;
    }

    /**
     * LOAD available TOUR GUIDE data
     * @return listTourGuide
     */
    public ArrayList<TourGuide> loadTourGuide() {
        BufferedReader load = null;
        File c = new File("TourGuide.txt");
        ArrayList<TourGuide> listTourGuide = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("TourGuide.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String city = part[0];
                    String name = part[1];
                    String monuments = part[2];
                    String language = part[3];
                    double price = Double.parseDouble(part[4]);

                    TourGuide C = new TourGuide(city,name,monuments,language,price);
                    listTourGuide.add(C);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listTourGuide;
    }

    /**
     * LOAD available HOTEL data
     * @return listHotel
     */
    public ArrayList<Hotel> loadHotel() {
        BufferedReader load = null;
        File c = new File("Hotel.txt");
        ArrayList<Hotel> listHotel = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("Hotel.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String city = part[0];
                    String name = part[1];
                    double price = Double.parseDouble(part[2]);
                    int stars = Integer.parseInt(part[3]);
                    boolean pets = Boolean.parseBoolean(part[4]);

                    Hotel C = new Hotel(city,name,price,stars,pets);
                    listHotel.add(C);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listHotel;
    }


    // --- RESERVE LIST PART --

    /**
     * LOAD the reverse of the FLIGHTS
     * @return listReserveFlight
     */
    public ArrayList<Flight> loadReserveFlight() {
        BufferedReader load = null;
        File c = new File("Reserve_Flight.txt");
        ArrayList<Flight> listReserveFlight = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("Reserve_Flight.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String codeUser = part[0];
                    String originAirport = part[1];
                    String destinationAirport = part[2];
                    String departure = part[3];
                    String arrival = part[4];
                    boolean business = Boolean.parseBoolean(part[5]);
                    double price = Double.parseDouble(part[6]);

                    Flight C = new Flight(codeUser,originAirport,destinationAirport,departure,arrival,business,price);
                    listReserveFlight.add(C);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listReserveFlight;
    }

    /**
     *  SAVE the NEW FLIGHT reservations
     * @param listReserveFlight list with all reservations flights
     */
    public static void saveReserveFlight(ArrayList<Flight>listReserveFlight) {
        PrintWriter save= null;
        try {
            save = new PrintWriter(new BufferedWriter(new FileWriter("Reserve_Flight.txt")));
            Collections.sort(listReserveFlight);

            for (Flight flight : listReserveFlight) {
                save.println(flight.getCodeUser()+";"+flight.getOriginAirport()+";"
                        +flight.getDestinationAirport()+";"+flight.getDeparture()+";"
                        +flight.getArrival()+";"+flight.getBusiness()+";"+flight.getPrice());
            }
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (save != null) {
                save.close();
            }
        }
    }


    /**
     * LOAD the reverse of the HOTEL
     * @return listReserveHotel
     */
    public ArrayList<Hotel> loadReserveHotel() {
        BufferedReader load = null;
        File c = new File("Reserve_Hotel.txt");
        ArrayList<Hotel> listReserveHotel = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("Reserve_Hotel.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String code = part[0];
                    String city = part[1];
                    String name = part[2];
                    double price = Double.parseDouble(part[3]);
                    String departure = part[4];
                    String arrival = part[5];
                    int stars = Integer.parseInt(part[6]);
                    boolean pets = Boolean.parseBoolean(part[6]);

                    Hotel h = new Hotel(code,city,name,price,departure,arrival,stars,pets);
                    listReserveHotel.add(h);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listReserveHotel;
    }

    /**
     * SAVE the NEW HOTEL reservations
     * @param listReserveHotel list with all reservations hotels
     */
    public static void saveReserveHotel(ArrayList<Hotel>listReserveHotel) {
        PrintWriter save= null;
        try {
            save = new PrintWriter(new BufferedWriter(new FileWriter("Reserve_Hotel.txt")));
            Collections.sort(listReserveHotel);

            for (Hotel hotel : listReserveHotel) {
                save.println(hotel.getCodeUser()+";"+hotel.getCity()+";"+hotel.getName()+";"+hotel.getPrice()+";"
                        +hotel.getDeparture()+";"+hotel.getArrival()+";"
                        +hotel.getStars()+";"+hotel.getPets());
            }
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (save != null) {
                save.close();
            }
        }
    }


    /**
     * LOAD the reverse of the TOUR GUIDE
     * @return listReserveGuide
     */
    public ArrayList<TourGuide> loadReserveGuide() {

        BufferedReader load = null;
        File c = new File("Reserve_Guide.txt");
        ArrayList<TourGuide> listReserveGuide = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("Reserve_Guide.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String codeUser = part[0];
                    String city = part[1];
                    String name = part[2];
                    String monuments = part[3];
                    String departure = part[4];
                    String language = part[5];
                    double price = Double.parseDouble(part[6]);

                    TourGuide g = new TourGuide(codeUser,city,name,monuments,departure,language,price);
                    listReserveGuide.add(g);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listReserveGuide;
    }

    /**
     * SAVE the NEW TOUR GUIDE reservations
     * @param listReserveGuide list with all reservations tours guides
     */
    public static void saveReserveGuide(ArrayList<TourGuide>listReserveGuide) {

        PrintWriter save= null;
        try {
            save = new PrintWriter(new BufferedWriter(new FileWriter("Reserve_Guide.txt")));
            Collections.sort(listReserveGuide);

            for (TourGuide guide : listReserveGuide) {
                save.println(guide.getCodeUser()+";"+ guide.getCity()+";"+guide.getName()+";"+guide.getMonuments()+
                        ";"+guide.getDeparture()+";"+guide.getLanguage()+";"+guide.getPrice());
            }
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (save != null) {
                save.close();
            }
        }
    }


    // --- USER LIST PART --

    /**
     * LOAD the data of registered USERS
     * @return listUser
     */
    public ArrayList<User> loadUser() {

        BufferedReader load = null;
        File c = new File("User.txt");
        ArrayList<User> listUser = new ArrayList();

        if (c.exists()) {
            try {
                load = new BufferedReader(new FileReader("User.txt"));
                String line = load.readLine();
                while (line != null) {

                    String[] part = line.split(";");
                    String code = part[0];
                    String name = part[1];
                    String dni = part[2];
                    int phone = Integer.parseInt(part[3]);
                    String country = part[4];
                    String city = part[5];

                    User u = new User(code,name,dni,phone,country,city);
                    listUser.add(u);

                    line = load.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    load.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listUser;
    }
}
