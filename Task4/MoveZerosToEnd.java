// 5. Move all zeros in a number to the end using a linked list(Ex: 1034035 ---> 1343500)

// Time complexity - O(N) and space complexity - O(N) 


import java.util.*;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MoveZerosToEnd {

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = in.nextInt();

        // Convert the number to a linked list
        Node head = null;
        Node tail = null;
        int zeroCount = 0;
        while (number > 0) {
            int digit = number % 10;
            if(digit == 0) zeroCount+=1;
            else{
                Node newNode = new Node(digit);
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    newNode.next = head;
                    head = newNode;
                }
            }
            number /= 10;
        }

        // System.out.println("Original Linked List:");
        // printList(head);
        while(zeroCount!=0){
            Node newNode = new Node(0);
            tail.next = newNode;
            zeroCount--;
        }

        System.out.println("Modified Linked List:");
        printList(head);
    }
}

