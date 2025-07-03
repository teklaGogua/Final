package oop.finalexam.t1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This program performs list management operations between two lists (list1 and list2)
 * to create a third list (list3) according to specific rules, with error handling for
 * out-of-bounds indices.
 * 
 * The algorithm works in two steps:
 * 1. For each element in list1, it uses the numeric value as an index to select an element
 *    from list2 (with offset +1). The selected element is combined with the original element
 *    in the format "[list1][list2]" and added to list3. If the index is out of bounds for list2,
 *    the element is skipped.
 * 2. After processing all elements, the program checks list1 again and removes elements from list3
 *    where the numeric value from list1 equals an index in list3.
 */
public class ListManager {
    /**
     * Main method that executes the list management process.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize list1 with predefined values as shown in the animation
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(7);
        list1.add(10);
        list1.add(3);
        list1.add(6);
        list1.add(8);
        list1.add(2);
        list1.add(1);
        list1.add(9);
        list1.add(4);

        System.out.println("List1: " + list1);
         
        // Initialize list2 with predefined values as shown in the animation
        List<String> list2 = new ArrayList<>();
        list2.add("vdp");
        list2.add("kcu");
        list2.add("ejr");
        list2.add("eln");
        list2.add("wfm");
        list2.add("bbk");
        list2.add("foz");
        list2.add("qfm");
        list2.add("atb");
        list2.add("nvj");
        list2.add("zrn");
        list2.add("huu");
        System.out.println("List2: " + list2);

        // Create list3 to store the results
        List<String> list3 = new ArrayList<>();
        
        // Step 1: Process list1 and list2 to create list3
        for (int i = 0; i < list1.size(); i++) {
            int indexFromList1 = list1.get(i);
            // Calculate index for list2 (value + 1)
            int list2Index = indexFromList1 + 1;
            
            try {
                // Get corresponding element from list2
                String list2Element = list2.get(list2Index);
                // Create combined string and add to list3
                String combined = list2Element + indexFromList1;
                list3.add(combined);
            } catch (IndexOutOfBoundsException e) {
                // Skip this element if index is out of bounds
                System.out.println("Skipping element " + indexFromList1 + 
                                 " at position " + i + 
                                 ": index " + list2Index + 
                                 " is out of bounds for list2");
            }
        }
        
        // Display list3 after step 1
        System.out.println("List3 after step 1: " + list3);
        
       // Step 2: Remove elements from list3 where list1 value equals an index in list3
       // First collect all valid indexes to remove
        Set<Integer> indexesToRemove = new HashSet<>();
        for (int value : list1) {
            if (value >= 0 && value < list3.size()) {
                indexesToRemove.add(value);
            }
        }

        // Convert to list and sort in descending order
        List<Integer> sortedIndexes = new ArrayList<>(indexesToRemove);
        sortedIndexes.sort(Collections.reverseOrder());

        // Remove from highest index to lowest to avoid index shifting issues
        for (int index : sortedIndexes) {
            list3.remove(index);
        }
        
        // Display final list3
        System.out.println("Final list3: " + list3);
    }
}