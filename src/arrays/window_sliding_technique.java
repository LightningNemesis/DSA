/*
WAP a program to find
1. Subarray with given sum (Check if the required sum can be found in the array as a subarray sum or not)
I/P: arr[] = {1, 8, 7, 11, 25, 30}, req_sum = 18
O/P: true

2. Sum of k consecutive integers
I/P: arr[] = {1, 8, 7, 11, 25, 30}, k = 4
O/P: 27 51 73

3. N Fibonacci Series upto M
i/p: n = 3, m = 8
o/p: 0, 0, 1, 1, 2, 4, 7, 13
 */

package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class window_sliding_technique {
    public static void main(String[] args) throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        /*System.out.println("Enter an array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();*/

        //System.out.println("Enter K");
        //int k = Integer.parseInt(br.readLine());
        //new sum_of_k_consecutive_integers().window_slider(arr, k);

        //System.out.println("Enter required sum");
        //int req_sum = Integer.parseInt(br.readLine());
        //System.out.println(new subarray_with_given_sum().window_slider(arr, req_sum));

        System.out.println("Enter N and M");
        int[] ip = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        new N_fibonacci_upto_M().Solver(ip[1], ip[0]);
    }
}


class sum_of_k_consecutive_integers {
    /**
     * Max of K consecutive elements
     * {1, 8, 30, -5, 20, 7}, K=3
    **/

    // Naive Approach
    void naive_slider(int[] arr, int k) {
        int n = arr.length;

        int max_sum = arr[0];
        for(int i=0; i<n-k; i++){
            int count = 1;
            int temp = arr[i];
            while(count<k){
                temp+=arr[i+count];
                count++;
            }
            max_sum = Math.max(temp, max_sum);
        }
        System.out.println(max_sum);
    }

    void window_slider(int [] arr, int k){
        int n = arr.length;

        int window_sum = 0;
        int max_sum = 0;

        //Calculate sum of first window (0 -> K-1)
        for(int i=0; i<k; i++){
            window_sum+=arr[i];
        }

        //Assign Window sum to Max sum (We will compare every window's sum with this and store max)
        max_sum = window_sum;

        //Finding all windows by adding Kth element (Last element of every new window) and subtracting the i-K th element (1st element of the previous window)
        for(int i=k; i<n; i++){
            window_sum += arr[i]; // Adding Last element of the new window
            window_sum -= arr[i-k]; // Removing 1st element of previous window
            max_sum = Math.max(max_sum, window_sum);
        }

        System.out.println(max_sum);
    }
}


// Note: ALL ELEMENTS SHOULD BE POSITIVE, This approach does not work with negative nos. in the series
class subarray_with_given_sum{
    /**
     *
     * @param arr, given_sum
     * @return true or false (Sum found or not)
     */

    boolean window_slider(int[] arr, int req_sum){
        int s = 0; // position to start removing elements from (When sum of window exceeds required sum)
        int curr_sum = arr[0];
        for(int e=1; e<arr.length; e++){
            // Cleaning the window till a) Sum of window is less than req sum OR b) It has only 1 element
            while(curr_sum>req_sum && s<e-1){
                curr_sum-=arr[s];
                s++;
            }

            // Checking if the window sum is equal to required sum
            if(curr_sum == req_sum) return true;
            else curr_sum+=arr[e];
        }
        if(curr_sum==req_sum) return true;
        else return false;
    }
}

class N_fibonacci_upto_M{

    void Solver(int M, int N){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // Storing the first N elements of the series
        for (int i=0; i<N-1; i++) {
            System.out.print(0 + " ");
            arr.add(0);
        }
        System.out.print(1+ " ");
        arr.add(1);

        //initial sum = sum of 1st N elements
        int curr_sum = 1; //if N = 3, curr_sum = 0+0+1

        for(int i = N; i<M; i++){
            System.out.print(curr_sum+ " ");
            arr.add(curr_sum);
            curr_sum = 2*curr_sum - arr.get(i-N);
        }
    }
}