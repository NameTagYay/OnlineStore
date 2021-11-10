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
                    break;

                case 3:
                    break;

                case 4:
                    break;
                default:
                    System.out.println("You don't know how to count apparently.");
            }

        }

    }
    public static void printMenu(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }
   //maybe public static void printAddInventory() from last store class ???
}
