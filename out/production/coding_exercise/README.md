# coding_exercise
 
**Requirements**
Write a standalone executable or script using the 
language of your preference (Java is the primary dev language at Expeditors).
Given the provided input data, print the expected 
output to the console or write to a text file.
 

**Expected Output**
* Each household and number of occupants
* Each First Name, Last Name, Address and Age sorted by 
  Last Name then First Name where the occupant(s) is older than 18

**Implementation**
* Created an Occupant object that contains the first name, last name, address, city, state,and age. 
* Created a Household object that has a list of occupants and address.
* Main is initialized as m in Main.java because I created functions **occupantPerHouse** and **sortedAlphaAge**; These functions
are created to print the expected output.
* Initialized an ArrayList of Occupant object to import the data; I chose to use an ArrayList for its built-in function 
but ultimately for its ability to dynamically change in size. 

**JUnit for testing**
* Tested for the number of occupants based on the input data. 
* Tested for sorted alphabetical last name then first name of occupants older than 18. 

_NOTE:_ Sample run is located in Main.java