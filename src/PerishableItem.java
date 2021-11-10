import java.io.Serializable;

public class PerishableItem extends Item implements Serializable {
    private int daysLeft;
    private boolean donateable;

    public PerishableItem(String name, double height, double length, double width, double weight, double price, int daysLeft){
        super(name, height,length,width,weight,price);
        donateable = true;
        this.daysLeft = daysLeft;
    }


}
