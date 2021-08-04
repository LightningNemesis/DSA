/*
Just in case you didn't know (like me),
Bitonic sequences are subsequences of an array which are FIRST INCREASING and then DECREASING
EG: arr = {1,11,2,10,4,5,2,1}
possible bitonics :-
{1,11,2}, {1,2,10,5,2,1}

Approach to solve:
1) Find LIS for each element in arr (SEARCHING FROM THE LEFT TILL EACH ELEMENT)
2) Find LDS for each element in arr (SEARCHING FROM THE RIGHT TILL EACH ELEMENT)

In the resultant arrays, iterate:
for each i, calculate max of LIS[i] + LDS[i] - 1 (Since 1 overlapping element)
 */
package DP.variations_LIS.longest_bitonic_subsequence;

import InputHandler.InputHandler;

import java.io.IOException;
import java.util.Arrays;

public class longest_bitonic_subsequence extends InputHandler {
    public static void main(String args[]) throws IOException {
        System.out.println("Enter array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().longest_bitonic_length_finder(arr, arr.length));
    }
}

class Solver {
    int longest_bitonic_length_finder(int[] arr, int n) {
        int[] lis = new int[n];
        int[] lds = new int[n];

        lis[0] =1;
        lds[n - 1] = 1;

        // Finding LIS
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], (1 + lis[j]));
                }

            }
        }


        // Finding LDS
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], (1 + lds[j]));
                }
            }
        }

        // Printing LIS and LDS
        System.out.print("LIS : ");
        printer(lis);
        System.out.print("LDS : ");
        printer(lds);

        int lbs = 0;
        for (int i =0; i<n; i++) {
            lbs = Math.max(lbs, lis[i] + lds[i] - 1);
        }
        return lbs;
    }

    void printer(int arr[]){
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }
}
