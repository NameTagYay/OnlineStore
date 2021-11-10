import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String username, password, name, address;
    private ArrayList<Integer> pastOrders;
    private LocalDate dob;
    private double distance;

    public Customer(String username, String password, String name, String address, ArrayList<Integer> pastOrders, LocalDate dob, double distance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.pastOrders = pastOrders;
        this.dob = dob;
        this.distance = distance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Integer> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(ArrayList<Integer> pastOrders) {
        this.pastOrders = pastOrders;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
