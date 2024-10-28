public class Occupant {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int age;

    public Occupant(String firstName, String lastName, String address, String city, String state, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.age = age;
    }

    public String getAddress(){
        return (this.address + ", " + this.city + ", " + this.state);

    }
    /*Only used to compare address; Cleans the data; We may not want this to be the official address*/
    protected String getFullAddress() {
        return (address + ", " + city + ", " + state)
                .toLowerCase()                   // Convert to lowercase
                .replaceAll("[.,]", "")           // Remove periods and commas
                .replaceAll("\\s+", " ")          // Replace multiple spaces with a single space
                .trim();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", " + this.getAddress() + ", " + this.age;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }
}

