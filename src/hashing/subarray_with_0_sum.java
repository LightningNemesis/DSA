/**
 * WAP to print whether a zero sum exists in sub-array
 * {5, 1, 2, -1, -2, -3, 4}
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class subarray_with_0_sum {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array to check for zero sum subarray");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        //Naive
        //System.out.println(new naive_approach_subarray_with_0_sum().zero_sum_check(arr));

        //Hashing
        System.out.println(new hashing_approach_subarray_with_0_sum().zero_sum_check(arr));
    }
}

class naive_approach_subarray_with_0_sum{
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param arr
     * @return
     */
    boolean zero_sum_check(int[] arr){
        for(int i=0; i<arr.length; i++){
            int temp_sum = 0;
            for(int j = i; j<arr.length; j++){
                temp_sum+=arr[j];
                if(temp_sum ==0) return true;
            }
        }
        return false;
    }
}

class hashing_approach_subarray_with_0_sum{
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param arr
     * @return
     */
    boolean zero_sum_check(int[] arr){
        int pre_sum = 0;
        HashSet<Integer> hs = new HashSet<Integer>(arr.length);
        for(int i: arr){
            pre_sum+=i;
            if(hs.contains(pre_sum)) return true; // if same prefix sum found, something had caused sum to decrease to 0
            if(pre_sum==0) return true;
            hs.add(pre_sum);
        }
        return false;
    }
}
