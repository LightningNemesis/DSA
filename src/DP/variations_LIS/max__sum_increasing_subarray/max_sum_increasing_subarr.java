package DP.variations_LIS.max__sum_increasing_subarray;

import InputHandler.InputHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class max_sum_increasing_subarr extends InputHandler {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().max_sum(arr, arr.length));
    }
}

class Solver{
    int max_sum(int[] arr, int n){
        int dp[] = new int[n]; // Each length index has the longest increasing subarr till that length
        dp[0] = arr[0]; // Since for length 1 of arr, size of (lis) = 1
        for(int i=1; i<n; i++){ // traversing in arr
            dp[i] = arr[i];
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[i], arr[i]+dp[j]);
            }
        }

        int max = dp[0];
        for(int i:dp){
            max = Math.max(max, i);
            //System.out.print(i+" ");
        }
        //System.out.println();
        return max;
    }
}