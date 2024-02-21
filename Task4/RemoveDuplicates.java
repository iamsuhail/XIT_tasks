// 3. Write a function to remove duplicates from an array


import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // return Arrays.stream(data).distinct().toArray(); -> stream API removes the duplicates in Time complexity - O(N) & Space - O(N)
        // HashSet/HashMap Time - O(N) & space - O(N)
        // sort and remove duplicate Time - O(NlogN) Space = O(1)
        System.out.print("Enter size of array: ");
        int n = in.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter sorted elements:");
        for(int i=0;i<nums.length;i++) nums[i] = in.nextInt();
        int j =0;
        j = removeDuplicate(nums);
        for(int i=0;i<j;i++) System.out.print(nums[i]+" ");
        
    }
    public static int removeDuplicate(int[] a){
        if (a.length == 0 || a.length == 1) {
            return a.length;
        }
 
        int j = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }
 
        a[j++] = a[a.length - 1];
 
        return j;
    }
    
}
