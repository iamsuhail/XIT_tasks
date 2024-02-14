// Problem Statement: ATM

// Consider an ATM with which we withdraw our cash. Now inside the atm, bank guys keep the notes like 2000*5,500*10,200*20,100*50. Write a program using recursion which takes the amount input from the user and gives the output in the format.

 

// Example: User enters the amount as 300, Output will be “Amount Debited: 200 – 1, 100 -1 “

// And also it should give no of notes in the atm ex: “After transaction 2000 notes – 100, 500 notes – 50 , 200 notes – 4 , 100 notes – 2 “.

 

// Input 1: Enter Denomination of notes , Ex1: No. of 2000 notes = 100,Ex2: No. of 500 notes =50 etc.. , same for all other denominations 

// Input 2: Amount a user wants to debit

// Output:   Denomination and No. of notes received by user after transaction,

 

// Example: Transaction of INR 2600

// Denomination: 2000x1,500x1,200x0,100 x1

// Note: ATM should dispense notes according to amount entered and it should choose the notes efficiently. For example, if user asks for 8000 and no of 2000 notes in atm are only 4…then program should not dispense all of 2000 notes. It can do 2000X2 , 500X4 …like wise. The program should look into how many notes are there, and what is the best denomination to dispense.

import java.util.*;

public class ATM
{
    // public static List<List<Integer>> allCombinations;
    public static int max = Integer.MIN_VALUE;
    public static Map<Integer, Integer> result;
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// allCombinations = new ArrayList<>();
		result = new HashMap<>();
		int[][] denomination = new int[4][2];
		denomination[0][0] = 2000; denomination[1][0] = 500; denomination[2][0] = 200; denomination[3][0] = 100;
		
        System.out.println("Enter Denomination");    
		System.out.println("Enter number of 2000 notes : ");
		denomination[0][1] = in.nextInt();
		System.out.println("Enter number of 500 notes : ");
		denomination[1][1] = in.nextInt();
		System.out.println("Enter number of 200 notes : ");
		denomination[2][1] = in.nextInt();
		System.out.println("Enter number of 100 notes : ");
		denomination[3][1] = in.nextInt();
		
		System.out.println("Enter the amount to be deducted from bank: ");
		int amount = in.nextInt();
		
		withdraw(0, denomination, amount, new ArrayList<>());
		
// 		System.out.println(allCombinations);
        System.out.println("Amount Debited: " + result);
		for(int i = 0; i < 4; i++) {
		    denomination[i][1] -= result.getOrDefault(denomination[i][0], 0);
		}
		System.out.println("After Transaction in ATM: ");
		for(int[] arr: denomination) {
		    System.out.println(arr[0] + " X " + arr[1]);
		}
	
	}

    public static void withdraw(int ind, int[][] denomination, int amount, List<Integer> combination) {
        if(ind == 4) {
            if(amount == 0) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for(int i: combination) map.put(i, map.getOrDefault(i, 0) + 1);
                if(map.size() > max) {
                    result = map;
                    max = map.size();
                }
                // allCombinations.add(new ArrayList<>(combination));
                return ;
            }
            return ;
        }
    
        
        if(amount - denomination[ind][0] >= 0 && denomination[ind][1] > 0) {
            combination.add(denomination[ind][0]);
            denomination[ind][1]--;
            withdraw(ind, denomination, amount - denomination[ind][0], combination);
            denomination[ind][1]++;
            combination.remove(combination.size() - 1);
        }
        
        withdraw(ind + 1, denomination, amount, combination);
    }
}



// Time complexity - O(2^n) and space complexity - O(n)
// Sample Test Cases

// Test case - 1

// Enter number of 2000 notes : 
// 4
// Enter number of 500 notes :
// 10
// Enter number of 200 notes :
// 10
// Enter number of 100 notes :
// 10
// Enter the amount to be deducted from bank:
// 8000
// Amount Debited: {2000=3, 500=3, 100=1, 200=2}
// After Transaction in ATM:
// 2000 X 1
// 500 X 7
// 200 X 8
// 100 X 9

// Test case - 2

// Enter Denomination
// Enter number of 2000 notes :
// 5
// Enter number of 500 notes :
// 4
// Enter number of 200 notes :
// 3
// Enter number of 100 notes :
// 2
// Enter the amount to be deducted from bank:
// 10000
// Amount Debited: {2000=4, 500=3, 100=1, 200=2}
// After Transaction in ATM:
// 2000 X 1
// 500 X 1
// 200 X 1
// 100 X 1

// Test case - 3

// Enter Denomination
// Enter number of 2000 notes :
// 1
// Enter number of 500 notes :
// 2
// Enter number of 200 notes :
// 3
// Enter number of 100 notes :
// 4
// Enter the amount to be deducted from bank:
// 4000
// Amount Debited: {2000=1, 500=2, 100=4, 200=3}
// After Transaction in ATM:
// 2000 X 0
// 500 X 0
// 200 X 0
// 100 X 0