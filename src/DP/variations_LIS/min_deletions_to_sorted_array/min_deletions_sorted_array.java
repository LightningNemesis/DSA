package DP.variations_LIS.min_deletions_to_sorted_array;

import InputHandler.InputHandler;

import java.io.IOException;
import java.util.Arrays;

public class min_deletions_sorted_array extends InputHandler {
    public static void main(String[] args)throws IOException{
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().count_deletions(arr, arr.length));
    }
}

class Solver{
    // Using the n(Log n) approach (Binary Search)
    int count_deletions(int [] arr, int n){
        int dp[] = new int[n+1]; // Contains the tail of LIS (last element in LIS)
        dp[0] = arr[0];
        int len = 1;
        for(int i=1; i<n; i++){
            if(arr[i]>dp[len-1]) {
                dp[len] = arr[i]; // If arr element at index i is greater than last element of dp, append}
                len++;
            }
            else{
                int pos = ceil_index(dp, len, arr[i]);
                dp[pos] = arr[i];
            }
        }

        return n-len;
    }

    int ceil_index(int [] arr, int n, int e){
        int l=0, u=n-1;
        while(l<u){
            int mid = (l+u)/2;
            if(arr[mid]>=e)
                u=mid;
            else
                l=mid+1;
        }
        return u;
    }

}