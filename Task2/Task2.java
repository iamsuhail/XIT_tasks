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
public class Task2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter Denomination of notes:");
        System.out.print("Enter the number of 2000 notes: ");
        int note2000 = in.nextInt();

        System.out.print("Enter the number of 500 notes: ");
        int note500 = in.nextInt();

        System.out.print("Enter the number of 200 notes: ");
        int note200 = in.nextInt();

        System.out.print("Enter the number of 100 notes: ");
        int note100 = in.nextInt();
        System.out.println("Amount a user wants to debit");
        int withdrawAmount = in.nextInt();


        System.out.println("Transaction of INR " + withdrawAmount);
        withdraw(withdrawAmount, note2000, note500, note200, note100);
        
        System.out.println("\nAfter transaction:");

        System.out.println("2000 notes - " + note2000);
        System.out.println("500 notes - " + note500);
        System.out.println("200 notes - " + note200);
        System.out.println("100 notes - " + note100);
        

    }
    public static void withdraw(int amount, int note2000, int note500, int note200, int note100) {
        if (amount == 0) {
            return;
        }
    
        if (amount >= 2000 && note2000 > 0) {
            int count = Math.min(amount / 2000, note2000);
            System.out.print("2000x" + count + " ");
            withdraw(amount - 2000 * count, note2000 - count, note500, note200, note100);
        } else if (amount >= 500 && note500 > 0) {
            int count = Math.min(amount / 500, note500);
            System.out.print("500x" + count + " ");
            withdraw(amount - 500 * count, note2000, note500 - count, note200, note100);
        } else if (amount >= 200 && note200 > 0) {
            int count = Math.min(amount / 200, note200);
            System.out.print("200x" + count + " ");
            withdraw(amount - 200 * count, note2000, note500, note200 - count, note100);
        } else if (amount >= 100 && note100 > 0) {
            int count = Math.min(amount / 100, note100);
            System.out.print("100x" + count + " ");
            withdraw(amount - 100 * count, note2000, note500, note200, note100 - count);
        }
    }
    
}
