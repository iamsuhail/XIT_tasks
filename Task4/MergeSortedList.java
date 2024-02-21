// 1. Write a function that merges two unsorted lists into a new sorted list

import java.util.*;
public class MergeSortedList {
    public static List<Integer> mergeAndSortLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        Collections.sort(mergedList);
        return mergedList;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter elements of the first list separated by spaces: ");
        List<Integer> list1 = getListFromInput(in.nextLine());

        System.out.print("Enter elements of the second list separated by spaces: ");
        List<Integer> list2 = getListFromInput(in.nextLine());

        List<Integer> result = mergeAndSortLists(list1, list2);
        System.out.println("Merged and sorted list: " + result);
    }

    private static List<Integer> getListFromInput(String input) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(input);

        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }

        return list;
    }
}
