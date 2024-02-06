import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task1_2{
    private static int minimumFloor = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people entering the elevator: ");
        int numPeople = scanner.nextInt();

        List<Integer> peopleFloors = new ArrayList<>();

        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter floor for person " + (i + 1) + ": ");
            int personFloor = scanner.nextInt();
            peopleFloors.add(personFloor);
        }
        System.out.print("Enter the curent floor of elevator: ");
        int currentFloor = scanner.nextInt();
        List<Integer> organisedRequests = organiseRequests(peopleFloors, currentFloor);

        // Serve all elevator requests
        for (int personFloor : organisedRequests) {
            System.out.println("Moving to Floor: " + personFloor);
            currentFloor = personFloor;
        }

        scanner.close();
    }

    private static List<Integer> organiseRequests(List<Integer> arr, int currFloor) {
        List<Integer> highFloors = new ArrayList<>();
        List<Integer> lowFloors = new ArrayList<>();

        for (int curr : arr) {
            if (curr >= currFloor) {
                highFloors.add(curr);
            } else {
                lowFloors.add(curr);
            }
        }

        // Sorting high floors, asc order
        Collections.sort(highFloors);
        // Sorting low floors, desc order
        Collections.sort(lowFloors, Comparator.reverseOrder());

        // The last floor should always be the minimum floor - 0
        List<Integer> organisedRequests = new ArrayList<>(highFloors);
        organisedRequests.addAll(lowFloors);
        organisedRequests.add(minimumFloor);

        return organisedRequests;
    }
}
