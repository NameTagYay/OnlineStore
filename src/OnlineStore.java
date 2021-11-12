import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class OnlineStore {
    public static ArrayList<Item> inventory;
    private static Scanner scanner1 = new Scanner(System.in);

@SuppressWarnings("unchecked")
    public static void loadInventory(){
        try{
            FileInputStream fis = new FileInputStream("file");
            ObjectInputStream ois = new ObjectInputStream(fis);
            inventory = (ArrayList<Item>)ois.readObject();
            System.out.println("Inventory: " + inventory.size() + " Items loaded");
            ois.close();
        }catch(Exception e){
            System.out.println("No Inventory Found! New Inventory Created");
            inventory = new ArrayList<>();
        }
    }
    public static void saveInventory(){
        try{
            FileOutputStream fos = new FileOutputStream("file",false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inventory);
            oos.close();
        }catch(Exception e){
            System.err.print("ERROR: Could not save the inventory!");
        }
    }

    public static void main(String[] args) {
        loadInventory();
        int n = 1;
        while (n != 5) {
            printMenu();
            n = scanner1.nextInt();scanner1.nextLine();
            switch (n) {
                case 1:
                    //Load inventory
                    loadInventory();
                    break;

                case 2:
                    //Add items in inventory
                    printAddInventory();
                    doAddInventory();
                    break;

                case 3:
                    //Remove items from inventory

                    break;

                case 4:
                    //Modify quantity of items

                    break;

                case 5:
                    //leave
                    break;

                default:
                    System.out.println("You don't know how to count apparently.");
            }

        }

    }
    public static void printMenu(){
        System.out.println("1 Print inventory: ");
        System.out.println("2 Add item: ");
        System.out.println("3 Remove item: ");
        System.out.println("4 Modify quantity: ");
        System.out.println("5 Leave: ");
    }
   //maybe public static void printAddInventory() from last store class ???
    public static void printAddInventory(){
        System.out.println(" What would you like to do?");
        System.out.println(" 1 - Add item");
        System.out.println(" 2 - Add perishable item");
        System.out.println(" 3 - Exit");
    }
    public static void doAddInventory() {
        int x = scanner1.nextInt();
        scanner1.nextLine();
        switch (x) {
            case 1: //base this on printAddInventoryMenu
                //String name, double height, double length, double width, double weight
                System.out.println("Item Name: ");
                String name = scanner1.nextLine();
                System.out.println("Item Height: ");
                double height = scanner1.nextDouble();
                scanner1.nextLine();
                System.out.println("Item length: ");
                double length = scanner1.nextDouble();
                scanner1.nextLine();
                System.out.println("Item width: ");
                double width = scanner1.nextDouble();
                scanner1.nextLine();
                System.out.println("Item weight: ");
                double weight = scanner1.nextDouble();
                scanner1.nextLine();
                Item i = new Item(name, height, length, width, weight);
                inventory.add(i);
                saveInventory();
                //add item
                break;

            case 2:
                // add perishable item
                //doesn't work
//            PerishableItem s = new PerishableItem( name,height, length, width, weight, price, daysLeft);
//            System.out.println("Name: ");
//            String name = scanner1.nextLine();
//            System.out.println("Height: ");
//            double height = scanner1.nextDouble();nuke.nextLine();
//            System.out.println("Length: ");
//            double length = scanner1.nextDouble();nuke.nextLine();
//            System.out.println("Width: ");
//
//            System.out.println("Weight: ");
//
//            System.out.println("Price: ");
//
//            System.out.println("Days left: ");
//            int daysLeft = nuke.nextLine();
                break;
            case 3:
                // leave
                break;

            default:
                System.out.println("You don't know how to count!");
        }
    }
}