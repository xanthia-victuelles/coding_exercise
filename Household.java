import java.util.ArrayList;
import java.util.Comparator;

public class Household {

    public static void main(String[] args) {
        // Create an ArrayList of occupants
        ArrayList<Occupant> occupants = new ArrayList<>();
        occupants.add(new Occupant("Dave", "Smith", "123 main st.", "seattle", "wa", 43));
        occupants.add(new Occupant("Alice", "Smith", "123 Main St.", "Seattle", "WA", 45));
        occupants.add(new Occupant("Bob", "Williams", "234 2nd Ave.", "Tacoma", "WA", 26));
        occupants.add(new Occupant("Carol", "Johnson", "234 2nd Ave", "Seattle", "WA", 67));
        occupants.add(new Occupant("Eve", "Smith", "234 2nd Ave.", "Tacoma", "WA", 25));
        occupants.add(new Occupant("Frank", "Jones", "234 2nd Ave.", "Tacoma", "FL", 23));
        occupants.add(new Occupant("George", "Brown", "345 3rd Blvd., Apt. 200", "Seattle", "WA", 18));
        occupants.add(new Occupant("Helen", "Brown", "345 3rd Blvd. Apt. 200", "Seattle", "WA", 18));
        occupants.add(new Occupant("Ian", "Smith", "123 main st ", "Seattle", "Wa", 18));
        occupants.add(new Occupant("Jane", "Smith", "123 Main St.", "Seattle", "WA", 13));

        //Checking the size of the list
        System.out.println("Size of List: " + occupants.size());

        //Each number of occupants per household
        ArrayList<Occupant> household = new ArrayList<Occupant>();


        //Sorting occupants that are older than 18 first
        ArrayList<Occupant> sortedAgeLastName = new ArrayList<Occupant>();
        for(Occupant occupant : occupants ){
            if (occupant.age >18){
                sortedAgeLastName.add(occupant);
            }
        }
        System.out.println("Sorting by age and lastname");

        //Sorting by lastname; using comparator to extract the lastName and compares alphabetically
        sortedAgeLastName.sort(Comparator.comparing(Occupant:: getLastName)); //method reference

        //Printing data for each occupant
        for (Occupant occupant : sortedAgeLastName){
            System.out.println(occupant);
        }



        //

    }
}
