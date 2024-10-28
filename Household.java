import java.util.ArrayList;
import java.util.Comparator;

public class Household {
    String address;
    ArrayList<Occupant> occupants;

    public Household(String address){
        this.address = address;
        this.occupants = new ArrayList<>();
    }

    public void addOccupant(Occupant o){
        occupants.add(o);
    }

    public int getHouseholdCount(){
        return occupants.size();
    }

    @Override
    public String toString() {
        return "Address: " + address + " Occupants: " +this.getHouseholdCount();
    }
}
