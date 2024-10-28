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

    public String getFullAddress() {
        return this.address + ", " + this.city + ", " + this.state;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", " + getFullAddress() + ", " + this.age;
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

