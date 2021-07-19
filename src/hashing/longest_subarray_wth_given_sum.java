/**
 * WAP to give the length of the longest subarray which has the sum equal to given sum
 * ip: {6 ,5, 8, -4, -4, 9, -2, 2}, sum = 13
 * op: 2 => {5, 8}
 *
 * ip: {8, 3, 1, 5, -6, 6, 2, 2}, sum=4
 * op: 4 {-6, 6, 2, 2}
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class longest_subarray_wth_given_sum {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array to find longest subarray with give sum");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter sum to check");
        int sum = Integer.parseInt(br.readLine());

        //Naive
        //System.out.println(new naive_solver_longest_subarray_wth_given_sum().length_count(arr, sum));

        //Hashing
        System.out.println(new hashing_solver_longest_subarray_wth_given_sum().length_count(arr, sum));

    }
}

class naive_solver_longest_subarray_wth_given_sum{
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param arr
     * @param given_sum
     * @return
     */
    int length_count(int[] arr, int given_sum){
        int max_length = 0;
        for(int i=0; i<arr.length; i++){
            int temp_sum = 0;
            for(int j=i; j<arr.length; j++){
                temp_sum+=arr[j];
                if(temp_sum==given_sum){
                    max_length = Math.max(j-i, max_length);
                    break;
                }
            }
        }
        return max_length;
    }
}

class hashing_solver_longest_subarray_wth_given_sum{
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param arr
     * @param given_sum
     * @return
     */
    int length_count(int[] arr, int given_sum){
        int max_length = 0;
        int prefix_sum = 0;
        int l = 0, r=0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(arr.length); // Key: prefix sum, Value: index
        for(int i=0; i<arr.length; i++){
            prefix_sum+=arr[i];
            // Checking if the 1st set of prefix sum itself contains required sum (no extra key)
            if(prefix_sum==given_sum){
                max_length=Math.max(i+1, max_length); //Updating max_length with i+1
                r=i;
            }

            if(hm.containsKey(prefix_sum-given_sum)){
                if((i - hm.get(prefix_sum-given_sum))> max_length){
                    l = hm.get(prefix_sum-given_sum)+1;
                    r = i;
                }
                max_length=Math.max(i - hm.get(prefix_sum-given_sum), max_length);
            }

            if(!hm.containsKey(prefix_sum))
                hm.put(prefix_sum, i);
        }
        for(int i=l; i<=r; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return max_length;
    }
}


