package DP.longest_common_subsequence;

import DP.InputHandler;

import java.io.IOException;
import java.util.Arrays;

public class longest_common_subsequence extends InputHandler {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter string 1");
        String str_1 = br.readLine();
        System.out.println("Enter string 2");
        String str_2 = br.readLine();
        //System.out.println("Largest common subsequence is: " + new memoization_solver(str_1.length(), str_2.length()).subsequence(str_1, str_2, str_1.length(), str_2.length()));
        System.out.println(new tabulation_solver().subsequence(str_1, str_2, str_1.length(), str_2.length()));
    }
}

class memoization_solver {
    int[][] mem_arr;

    memoization_solver(int m, int n) {
        mem_arr = new int[m + 1][n + 1];
        for (int[] r : mem_arr)
            Arrays.fill(r, -1); // Since subsequences can be min 0
    }

    int subsequence(String s1, String s2, int m, int n) {
        if (mem_arr[m][n] == -1) {
            if (m == 0 || n == 0) mem_arr[m][n] = 0; // Base case
            else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                mem_arr[m][n] = 1 + subsequence(s1, s2, m - 1, n - 1); // Decrementing both strings by 1
            } else {
                mem_arr[m][n] = Math.max(subsequence(s1, s2, m - 1, n), subsequence(s1, s2, m, n - 1));
            }
        }
        return mem_arr[m][n];
    }
}

class tabulation_solver {
    int subsequence(String s1, String s2, int m, int n) {
        int[][] tab_arr = new int[m + 1][n + 1];
        for(int i=0; i<=n; i++){
            tab_arr[0][i] = 0;
        }
        for(int i=0; i<=m; i++){
            tab_arr[i][0] = 0;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    tab_arr[i][j] = 1+tab_arr[i-1][j-1];
                else{
                    tab_arr[i][j] = Math.max(tab_arr[i-1][j],tab_arr[i][j-1]);
                }
            }
        }
        for(int i[]:tab_arr){
            for(int j: i )
                System.out.print(j + " ");
            System.out.println();
        }
        return tab_arr[m][n];
    }
}


