import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class CustomerPortal {
    private static Statement stmt;
    private static Scanner  sc;
    private static Customer customer;

    public static void main(String[] args) {
        stmt = new DBInterface("database.db").getStatement();
        sc = new Scanner(System.in);

        int n = -1;

        System.out.println("#### Welcome to Generic Store #####\n");
        while (n != 3) {
            printMenu();
            n = sc.nextInt();
            sc.nextLine();
            if (n == 1) {
                createUser();
            } else if (n == 2) {
                signIn();
            } else {
                System.out.println("Thank you for shopping with us");
            }
        }
    }

    private static void portal(){
        int n = -1;
        while(n !=3){
            System.out.println("1. Modify Profile");
            System.out.println("2. Place order");
            System.out.println("3. Log off");
            n = sc.nextInt(); sc.nextLine();
            switch(n){
                case 1:
                    modifyProfile();
                    break;

                case 2:
                    placeOrder();
                    break;
                case 3:
                    System.out.println("Logged out.");
                    updateCustomer();
                    customer = null;
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }
    private static void placeOrder(){
        ArrayList<Item> items = new ArrayList<>();
        System.out.println("Enter search");
        String ans = sc.nextLine();
        while(!ans.equalsIgnoreCase("Exit")){

        }
    }
    private static void modifyProfile(){
        int n = -1;
        while (n != 4){
            System.out.println("1. Change name");
            System.out.println("2. Change password");
            System.out.println("3. Change address");
            System.out.println("4. Exit");
            n = sc.nextInt();sc.nextLine();

            switch(n){
                case 1:
                    System.out.println("Enter name");
                    customer.setName(sc.nextLine());
                    break;
                case 2:
                    String pass1="";
                    String pass2="";
                    while(!pass1.equals(pass2)) {
                        System.out.println("Enter new password.");
                        pass1 = sc.nextLine();
                        System.out.println("Confirm password");
                        pass2 = sc.nextLine();
                        if (!pass1.equals(pass2)) {
                            System.out.println("try again");
                        }
                    }
                    customer.setPassword(pass1);
                    break;
                case 3: // set address, oops we already know it!
                    System.out.println("No worries we already know it!");
                    break;
                case 4: //exit
                    break;
                default:
                    System.out.println("try again");
                    break;
            }
        }
    }
    private static void signIn(){
        String username="";
        boolean loggedIn = false;
        while (true){
            System.out.println("Enter username ");
            username = sc.nextLine();
            try {
                ResultSet set = stmt.executeQuery("SELECT Password FROM Customer WHERE Username=\""+username+"\"");
                if (set.next()){
                    loggedIn =true;
                    break;
                }
                else{
                    System.out.println("Invalid password");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }else{
                System.out.println("User not found");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }


    private static void createUser() {
        while(true){
            System.out.print("Enter a username:");
            String usr = sc.nextLine();
            try{
                ResultSet  set = stmt.executeQuery("SELECT * FROM Customers WHERE Username=\""+usr+"\"");
                if(set.getFetchSize() !=0)
                    System.out.println("Username already taken! please choose another");
                else
                    break;
            }catch(SQLException e){
                System.out.println(e);
            }
            System.out.print("Enter password: ");
            String pass  = sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter address: ");
            String addr = sc.nextLine();
            String dob ="";
            while(true) {
                System.out.print("Enter date of birth (yyyy\\mm\\dd): ");
                dob = sc.nextLine();
                if(dob.matches("\\d{4}\\\\d\\d\\\\d\\d"))
                    break;
            }
            LocalDate DOB = LocalDate.parse(dob);
            Customer c = new Customer(usr, pass,name, addr,DOB);
            int dist = c.getDistance();
            try{
                stmt.execute("INSERT INTO Customers VALUES ("+usr+",+"+pass+","+name+","+addr+",)");
            }catch(SQLException e){
                System.out.println(e);
            }


        }
    public static void setCustomer(String username){
            Customer c;
            try{
                ResultSet set = stmt.executeQuery("SELECT * FROM Customers WHERE Username=\""+username+"\"");
                String pass = set.getString(2);
                String name = set.getString(3);
                String address = set.getString(4);
                LocalDate dob = LocalDate.parse(set.getString(5));
                int dist = set.getInt(6);
                customer = new Customer(username,pass,name,address,dob,dist);
            }catch(SQLException e){
                System.out.println(e);
            }
        }

    }

    private static void printMenu() {
        System.out.println("1. Sign up");
        System.out.println("2. Sign in");
        System.out.println("3. Exit");
    }
    public static void updateCustomer(){
        String name = customer.getName();
        String password = customer.getPassword();
        String address = customer.getAddress();
        int distance = customer.getDistance();

        try{
            stmt.execute("UPDATE Customer SET (Name,Password,Address,Distance) = (\""+name+"\",\""+password+"\",\""+address+"\","+distance+")");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




}