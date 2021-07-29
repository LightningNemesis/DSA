/**
 * Ip: {2,5,3,6}, sum = 5
 * op:
 * 2: 2+3
 * 5: 5
 */
package DP.coin_denominations_sum;

import InputHandler.InputHandler;
import java.util.*;

import java.io.IOException;

public class coin_denom_sum extends InputHandler {
    public static void main(String[] args)throws IOException{
        System.out.println("Enter array of denominations");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum");
        int sum = Integer.parseInt(br.readLine());
        System.out.println(new Solver(arr.length, sum).count_combinations_woutdp(arr, arr.length, sum));
    }
}

class Solver{
    int dp[][];
    Solver(int m, int sum){
        dp = new int[m+1][sum+1];
    }

    int count_combinations_woutdp(int arr[], int m, int sum){
        if(sum == 0) return 1; //We have found 1 combination
        if(m==0) return 0; //We don't have coins left for any other combination

        int res = count_combinations_woutdp(arr, m-1, sum); // Not including the denomination
        if(arr[m-1]<=sum)
            res = res + count_combinations_woutdp(arr, m, sum-arr[m-1]); //including the denomination & reducing sum

        return res;
    }

    int count_combinations_wdp(int arr[], int m, int sum){
        if(dp[m][sum]==-1){
            if(sum == 0) dp[m][sum] = 1; //We have found 1 combination
            if(m==0) dp[m][sum]=0; //We don't have coins left for any other combination

            dp[m][sum] = count_combinations_woutdp(arr, m-1, sum); // Not including the denomination
            if(arr[m-1]<=sum)
                dp[m][sum] = dp[m][sum] + count_combinations_woutdp(arr, m, sum-arr[m-1]); //including the denomination & reducing sum
        }
        return dp[m][sum];
    }
}
