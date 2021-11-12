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
        while (n != 4) {
            printMenu();
            n = scanner1.nextInt();scanner1.nextLine();
            switch (n) {
                case 1:
                    loadInventory();
                    break;

                case 2:
                    //Add items in inventory
                    break;

                case 3:
                    //Remove items from inventory
                    break;

                case 4:

                    //Modify quantity of items
                    break;

                case 5:
                    saveInventory();
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
}
