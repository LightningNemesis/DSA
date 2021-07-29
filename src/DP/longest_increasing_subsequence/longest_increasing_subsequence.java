package DP.longest_increasing_subsequence;

import InputHandler.InputHandler;

import java.io.IOException;
import java.util.Arrays;

public class longest_increasing_subsequence extends InputHandler {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().LIS_binary_search(arr, arr.length));
    }

}

class Solver {
    /*
    {3,4,2,8,10}
    Note: We cannot use a dp array, since we need to find the largest element in the array first and then create
          dp[largest_element+1], this will cause space wastage
    Note IMP: Why waste 1 extra traversal when we can solve the problem in 1 traversal
    Therefore, DP is a thought process :()
     */

    int LIS(int[] arr, int n) {
        if (n <= 1) return 1;
        if (arr[n - 1] > arr[n - 2]) {
            return 1 + LIS(arr, n - 1);
        } else {
            return 0 + LIS(arr, n - 1);
        }
    }

    /*
    arr = {3,4,2,8,10}
    dp =  {1,2,1,3,4}
    Time Complexity:
     */
    int LIS_dp(int[] arr, int n) {
        int dp[] = new int[n]; // stores the LIS ENDING WITH arr[i]
        dp[0] = 1; // Since LIS, when only 1 element exists in arr, is gonna be 1

        for(int i=1; i<n; i++){
            int res = 1;
            for(int j=i-1; j>=0; j--){
                if(arr[i]>arr[j])
                    res = Math.max(res, 1+dp[j]);
            }
            dp[i] = res;
        }

        int max = dp[0];
        for(int i: dp)
            max = Math.max(max, i);
        return max;
    }

    int LIS_binary_search(int[] arr, int n){
        int[] tail = new int[n+1];
        tail[0] = arr[0];
        int len = 1;
        for(int i=1; i<n; i++){
            if(arr[i]>tail[len-1]) {
                tail[len] = arr[i];
                len++;
            }
            else{
                int pos = replace_ceil_element(arr, arr.length, arr[i]);
                tail[pos] = arr[i];
            }
        }

        return len;
    }

    int replace_ceil_element(int[] arr, int n, int repl){
        int l=0, u =n;
        while(l<u){
            int mid = (l+u)/2;
            if(arr[mid]>=repl)
                u=mid;
            else l=mid+1;
        }
        return u;
    }


}