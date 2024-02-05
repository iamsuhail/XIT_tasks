// Problem Statement: Elevator Configuration

// Every Elevator runs based on certain rules predefined. So, Here we will be doing the same.

// There is an 10 Stories Building.

// Elevator should be configured based on 2 use cases

// 1. First come First Server.

// 2. Nearest Floor Serve First

 

// Example for use case 2: Person 1 Standing at Floor 1 requests for the elevator service first.

// Person 2 from floor 8 requests for the elevator service second

// Person 3 from floor 3 request for the elevator service third.

// Elevator is at floor 0.

// Now Elevator should receive Person 1 first Person 3 second and Person 2 at the last.

 

// Example for Scenario 1: 4 People entered elevator from floor 5.

// Person 1: Requests to go at floor 3

// Person 2: Requests to go at floor 6

// person 3: Requests to go at floor 10

// person 4: Requests to go at floor 1


// Elevator should start moving in the direction first which is nearest from the current floor.

// NOTE: Number of floors, Number of persons entering an Elevator, Number of person requesting Elevator should be user Input. Do not hard code these parameters.

import java.util.*;


public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of floors in the building: ");
        int numFloors = in.nextInt();

        System.out.print("Enter the number of people entering the elevator: ");
        int numPeople = in.nextInt();

        int[] currentFloor = { 0 }; // Array of size 1
        System.out.print("Enter the current floor of lift:");
        currentFloor[0] = in.nextInt();

        List<Integer> peopleFloors = new ArrayList<>();

        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter floor for person " + (i + 1) + ": ");
            int personFloor = in.nextInt();
            peopleFloors.add(personFloor);
        }

        // Nearest Floor Serve First
        // Collections.sort(peopleFloors);
        Collections.sort(peopleFloors, Comparator.comparingInt(floor -> Math.abs(floor - currentFloor[0])));
        
        for (int personFloor : peopleFloors) {
            System.out.println("Moving to Floor " + personFloor);
            // currentFloor[0] = personFloor;
        }

        in.close();
    }
}
