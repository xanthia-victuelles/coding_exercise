import java.util.ArrayList;
import java.util.Comparator;


public class Main {

    /* This function returns an ArrayList of Household object and takes an Arraylist of Occupants
    * For each occupant, checks if the address is already in the list. If it is not in, it adds it to Households as a newHouse.
    * Additionally, adding the occupant along to the newHouse. */
    public ArrayList<Household> occupantPerHouse(ArrayList<Occupant> occupants){
        ArrayList<Household> households = new ArrayList<Household>();
        for (Occupant o : occupants) {
            //to check if the household already exist
            Household existHouse = null;

            for (Household h : households) {
                if (h.address.equalsIgnoreCase(o.getFullAddress())){ //getFullAddress() is only used to clean the data here.
                    existHouse = h;
                    break;
                }
            }
            if(existHouse != null) {
                existHouse.addOccupant(o);
            }else {
                Household newHouse = new Household(o.getFullAddress());
                newHouse.addOccupant(o); // Adds occupant to the newHouse obj
                households.add(newHouse);
            }
        }
        return households;
    }
    /*This function returns an Arraylist of sorted occupants by last name and age is older than 18
    * it takes in Arraylist of occupants. Fisrt, filtering the occupants age, then using the sorted list to sort the list
    * alphabetically.*/

    public ArrayList<Occupant> sortedAlphaAge(ArrayList<Occupant> occupants){
        ArrayList <Occupant> sortedAgeLastName = new ArrayList<Occupant>();
        for (Occupant occupant : occupants) {
            if (occupant.age > 18) {
                sortedAgeLastName.add(occupant);
            }
        }
        //Sorting by lastname; using comparator to extract the lastName then the firstname and compares alphabetically
        sortedAgeLastName.sort(Comparator.comparing(Occupant::getLastName).thenComparing(Occupant::getFirstName)); //method reference
        return sortedAgeLastName;
    }


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

        Main m= new Main();

        //Each number of occupants per household
        ArrayList<Household> households = m.occupantPerHouse(occupants);

        System.out.println("____________________________");
        System.out.println("   Occupant per household");
        System.out.println("____________________________");

        //Printing data for each household
        for(Household h : households){
            System.out.println(h);
        }

        //Sorting occupants that are older than 18 first
        ArrayList<Occupant> sortedAgeLastName = m.sortedAlphaAge(occupants);
        //Printing data for each occupant
        System.out.println("____________________________");
        System.out.println("Sorting by age and lastname");
        System.out.println("____________________________");

        for (Occupant occupant : sortedAgeLastName) {
            System.out.println(occupant);
        }

        //Unit Test with JUnit
        System.out.println("____________________________");
        System.out.println("Running Unit Test");
        System.out.println("____________________________");

        TestMain test = new TestMain();
        test.setUp(m, occupants); //Passing the current instance for testing
        test.testSortedAlphaAge();
        test.testOccupantPerHouse();

        System.out.println("Test completed");



    }
}
/*
Sample Output:
/Users/katemasangkay/Library/Java/JavaVirtualMachines/openjdk-22/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=51403:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/out/production/coding_exercise:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/junit-jupiter-5.8.1.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/junit-jupiter-api-5.8.1.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/opentest4j-1.2.0.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/junit-platform-commons-1.8.1.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/apiguardian-api-1.1.2.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/junit-jupiter-params-5.8.1.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/junit-jupiter-engine-5.8.1.jar:/Users/katemasangkay/Documents /GitHub/coding_exercise_expeditors/lib/junit-platform-engine-1.8.1.jar Main
Size of List: 10
____________________________
   Occupant per household
____________________________
Address: 123 main st seattle wa Occupants: 4
Address: 234 2nd ave tacoma wa Occupants: 2
Address: 234 2nd ave seattle wa Occupants: 1
Address: 234 2nd ave tacoma fl Occupants: 1
Address: 345 3rd blvd apt 200 seattle wa Occupants: 2
____________________________
Sorting by age and lastname
____________________________
Carol Johnson, 234 2nd Ave, Seattle, WA, 67
Frank Jones, 234 2nd Ave., Tacoma, FL, 23
Alice Smith, 123 Main St., Seattle, WA, 45
Dave Smith, 123 main st., seattle, wa, 43
Eve Smith, 234 2nd Ave., Tacoma, WA, 25
Bob Williams, 234 2nd Ave., Tacoma, WA, 26
____________________________
Running Unit Test
____________________________
Test completed

Process finished with exit code 0

*/