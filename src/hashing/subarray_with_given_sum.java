/**
 * WAP to check if subarray contains the given sum
 * ip: {5, 8, 20, -1, -3}, gs = 27
 * op: true
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class subarray_with_given_sum {
    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        System.out.println("Enter array to check for subarray sum");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum to check");
        int given_sum = Integer.parseInt(br.readLine());

        //Naive
        //System.out.println(new naive_solver_subarray_with_given_sum().given_sum_checker(arr, given_sum));

        //Hashing
        System.out.println(new hashing_solver_subarray_with_given_sum().give_sum_checker(arr, given_sum));

    }
}

class naive_solver_subarray_with_given_sum {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr
     * @param given_sum
     * @return
     */
    boolean given_sum_checker(int[] arr, int given_sum) {
        for (int i = 0; i < arr.length; i++) {
            int temp_sum = 0;
            for (int j = i; j < arr.length; j++) {
                temp_sum += arr[j];
                if (temp_sum == given_sum) return true;
            }
        }
        return false;
    }
}

class hashing_solver_subarray_with_given_sum {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param arr
     * @param given_sum
     * @return
     */
    boolean give_sum_checker(int[] arr, int given_sum) {
        int pre_sum = 0;
        HashSet<Integer> hs = new HashSet<Integer>(arr.length);
        for (int i : arr) {
            pre_sum += i;
            if (pre_sum == given_sum) return true;
            if (hs.contains(pre_sum - given_sum)) return true;
            hs.add(pre_sum);
        }
        return false;
    }
}
