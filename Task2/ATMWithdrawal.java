import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMWithdrawal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> denominations = new HashMap<>();
        denominations.put(2000, 0);
        denominations.put(500, 0);
        denominations.put(200, 0);
        denominations.put(100, 0);

        // Input: Number of notes for each denomination
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            System.out.print("Enter the number of " + entry.getKey() + " notes: ");
            entry.setValue(in.nextInt());
        }

        // Input: Amount to be withdrawn
        System.out.print("Enter the amount to be withdrawn: ");
        int amount = in.nextInt();

        in.close();

        // Output: Denominations and number of notes received by the user
        System.out.println("Transaction of INR " + amount);
        withdraw(amount, denominations);

        // Output: Remaining notes in the ATM
        System.out.println("\nAfter transaction:");
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            System.out.println(entry.getKey() + " notes - " + entry.getValue());
        }
    }

    public static void withdraw(int amount, Map<Integer, Integer> denominations) {
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            int denomination = entry.getKey();
            int availableNotes = entry.getValue();

            if (amount >= denomination && availableNotes > 0) {
                int count = amount / denomination;
                count = Math.min(count, availableNotes);

                System.out.print(denomination + "x" + count + " ");
                
                amount -= denomination*count;
                entry.setValue(availableNotes - count);

                if (amount == 0) {
                    break;
                }
            }
        }
    }
}
