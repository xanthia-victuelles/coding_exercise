import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private Main mainInstance;
    private ArrayList<Occupant> occupants;

    @BeforeEach
    public void setUp(Main m, ArrayList<Occupant> o) {
        mainInstance = m;
        occupants = o;
      }
    @Test
    public void testOccupantPerHouse() {
        ArrayList<Household> households = mainInstance.occupantPerHouse(occupants);

        // Validate the number of households and the occupant count for each normalized address
        assertEquals(5, households.size());
        assertEquals(4, getOccupantCountForAddress(households, "123 main st seattle wa"));
        assertEquals(2, getOccupantCountForAddress(households, "234 2nd ave tacoma wa"));
        assertEquals(1, getOccupantCountForAddress(households, "234 2nd ave seattle wa"));
        assertEquals(1, getOccupantCountForAddress(households, "234 2nd ave tacoma fl"));
        assertEquals(2, getOccupantCountForAddress(households, "345 3rd blvd apt 200 seattle wa"));
    }

    @Test
    public void testSortedAlphaAge() {
        ArrayList<Occupant> sortedOccupants = mainInstance.sortedAlphaAge(occupants);

        // Checks if occupants younger than or equal to 18 are filtered out
        assertEquals(6, sortedOccupants.size());

        // Checks if sorted order by last name and then by first name for those over 18
        assertEquals("Carol Johnson", sortedOccupants.get(0).firstName + " " + sortedOccupants.get(0).lastName);
        assertEquals("Frank Jones", sortedOccupants.get(1).firstName + " " + sortedOccupants.get(1).lastName);
        assertEquals("Alice Smith", sortedOccupants.get(2).firstName + " " + sortedOccupants.get(2).lastName);
        assertEquals("Dave Smith", sortedOccupants.get(3).firstName + " " + sortedOccupants.get(3).lastName);
        assertEquals("Eve Smith", sortedOccupants.get(4).firstName + " " + sortedOccupants.get(4).lastName);
        assertEquals("Bob Williams", sortedOccupants.get(5).firstName + " " + sortedOccupants.get(5).lastName);
    }

    // Helper method to get the occupant count for a specific address; Only used for testing
    private int getOccupantCountForAddress(ArrayList<Household> households, String address) {
        for (Household household : households) {
            if (household.address.equals(address)) {
                return household.getHouseholdCount();
            }
        }
        return 0;
    }

}
