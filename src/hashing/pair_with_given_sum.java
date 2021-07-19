/**
 * WAP to input an arr and check if it contains a pair (consecutive not mandatory) whose sum is equal to given sum
 *
 * ip: {10, 2, -1, 5}, sum = 15
 * op: True (10+5)
 *
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class pair_with_given_sum {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir =new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(ir);
        System.out.println("Enter array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum to find");
        int sum = Integer.parseInt(br.readLine());

        //Naive
        //System.out.println(new naive_solver_pair_with_given_sum().pair_with_sum_exists(arr, sum));

        //Hashing
        System.out.println(new hashing_solver_pair_with_given_sum().pair_with_sum_exists(arr, sum));

    }
}

class naive_solver_pair_with_given_sum{
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param arr
     * @param sum
     * @return
     */
    boolean pair_with_sum_exists(int [] arr, int sum){
        if(arr.length<=1) return false; //Need min 2 elements
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==sum) return true;
            }
        }
        return false;
    }
}



class hashing_solver_pair_with_given_sum{
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    boolean pair_with_sum_exists(int [] arr, int given_sum){
        HashSet<Integer> hs = new HashSet<Integer>(arr.length);
        for(int i: arr){
            if(hs.contains(given_sum-i)) return true;
            else hs.add(i);
        }
        return false;
    }
}
