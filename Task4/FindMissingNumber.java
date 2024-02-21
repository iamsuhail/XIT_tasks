// 4. Find the missing number in a given integer array of 1 to 100

import java.util.*;
public class FindMissingNumber {
    public static int findMissingNumber(int[] array) {
        int expectedSum = 5050; // Sum of numbers from 1 to 100
        int actualSum = 0; // Arrays.stream(array).sum();
        for (int num : array) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 7, 8, 9, 10}; // Missing 5
        int missingNumber = findMissingNumber(array);
        System.out.println("Missing number: " + missingNumber);
    }
}