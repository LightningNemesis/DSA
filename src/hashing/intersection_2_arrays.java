/**
 * WAP to take 2 input arrays(unordered) and print the no. of common elements between those 2 arrays
 * NOTE: There might be duplicate elements, but count of common elements should take only one appearance into account
 * <p>
 * ip:
 * arr1 = {10, 14, 15, 5, 6, 5, 14}
 * arr2 = {14, 3, 5, 14, 10}
 * <p>
 * op: 3 (14, 5, 10)
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class intersection_2_arrays {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter first array");
        int[] arr1 = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter second array");
        int[] arr2 = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();


        System.out.println("The no. of common elements are");
        // Using Naive method
        /*if (arr1.length > arr2.length)
            System.out.println(new naive_solver_intersection_2_arrays().count_common_elements(arr1, arr2));
        else System.out.println(new naive_solver_intersection_2_arrays().count_common_elements(arr2, arr1));*/

        // Using hashing
        //System.out.println(new hashing_solver_intersection_2_arrays().count_common_elements(arr1, arr2));
        System.out.println(new hashing_solver_intersection_2_arrays().count_common_elements_efficient(arr1, arr2));


    }
}

class naive_solver_intersection_2_arrays {
    /**
     * Time complexity: O(m*(m+n))
     * Space complexity: O(1)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    int count_common_elements(int[] arr1, int[] arr2) { // such that arr1.length > arr2.length
        int n1 = arr1.length;
        int n2 = arr2.length;

        int common_count = 0;
        for (int i = 0; i < n2; i++) {
            boolean seen_before = false;
            for (int j = 0; j < i; j++) {
                if (arr2[i] == arr2[j]) {
                    seen_before = true;
                    break;
                }
            }
            if (seen_before) continue;

            // Reached here, so we've found an unseen element in smaller arr, now checking for
            // occurrence in larger arr, if found, increment count and break
            for (int j = 0; j < n1; j++) {
                if (arr1[j] == arr2[i]) {
                    common_count++;
                    break;
                }
            }
        }

        return common_count;
    }
}

class hashing_solver_intersection_2_arrays {
    /**
     * Time Complexity: O(2n+m
     * Space Complexity: O(n)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    int count_common_elements(int[] arr1, int[] arr2) { // such that arr1.length > arr2.length
        int n1 = arr1.length;
        int n2 = arr2.length;
        int common_count = 0;

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(n2); // creating a hashmap with size of smaller array

        // 1st O(n) operation, storing keys with value 0
        for (int i : arr2) {
            hm.put(i, hm.getOrDefault(i, 0));
        }

        // 2nd O(n) operation, incrementing values whose keys are present in arr1
        for (int i : arr1) {
            if (hm.containsKey(i)) { // If common key found, increase frequency of common element by 1
                hm.put(i, hm.get(i) + 1);
            }
        }

        // 3rd O(n) operation, storing the no. of keys with values non 0
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() != 0) {
                common_count++;
            }
        }
        return common_count;
    }

    /**
     * Time complexity: O(n+m)
     * Space complexity: O(n)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    int count_common_elements_efficient(int[] arr1, int[] arr2) {
        HashSet<Integer> hs1 = new HashSet<Integer>(arr1.length);
        int common_count = 0;
        for (int i : arr1)
            hs1.add(i); // Getting all the unique elements from arr1 as keys
        for (int i : arr2) {
            if (hs1.contains(i)) {
                common_count++;
                hs1.remove(i); // We want only the first instance of the common element
            }
        }
        return common_count;
    }
}
