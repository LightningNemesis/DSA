/**
 * WAP to input 2 unsorted arrays and return the number of distinct elements in both arrays combined
 * <p>
 * ip:
 * arr1 = {10, 12, 15}
 * arr2 = {1, 12, 3}
 * <p>
 * op: 5 => {10, 12, 15, 1, 3}
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class union_2_unsorted_arrays {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array 1");
        int[] arr1 = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter array 2");
        int[] arr2 = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();

        //Naive
        //System.out.println(new naive_sovler_union_2_unsorted_arrays().distinct_merger(arr1, arr2));

        //Hashing
        System.out.println(new hashing_solver_union_2_unsorted_arrays().distinct_merger(arr1, arr2));
    }
}


class naive_sovler_union_2_unsorted_arrays {
    /**
     * Time complexity: O(n+m+(n+m)^2)
     * Space complexity: O(n+m)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    int distinct_merger(int[] arr1, int[] arr2) {
        ArrayList<Integer> n_arr = new ArrayList<Integer>(arr1.length + arr2.length); //Worst case all elemnets in combined array will be unique
        for (int i : arr1) {
            n_arr.add(i);
        }
        for (int i : arr2) {
            n_arr.add(i);
        }

        int distinct_count = 0;
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            boolean seen_before = false;
            for (int j = 0; j < i; j++) {
                if (n_arr.get(j) == n_arr.get(i))
                    seen_before = true;
            }
            if (seen_before) continue;
            else distinct_count++;
        }
        return distinct_count;
    }
}

class hashing_solver_union_2_unsorted_arrays {
    /**
     * Time complexity: O(n+m)
     * Space complexity: O(n+m)
     * @param arr1
     * @param arr2
     * @return
     */
    int distinct_merger(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>(arr1.length + arr2.length);

        //Simpler approach
        for(int i: arr1)
            hs.add(i);
        for(int i: arr2)
            hs.add(i);

        // 1 traversal approach
        /*for (int i = 0; i < (arr1.length + arr2.length); i++) {
            if (i < arr1.length) hs.add(arr1[i]);
            else hs.add(arr2[i % arr1.length]);
        }*/

        return hs.size();
    }
}
