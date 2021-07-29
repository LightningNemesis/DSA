package DP.str_equal_min_operations;

import InputHandler.InputHandler;

import java.io.IOException;

public class min_ops extends InputHandler {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter 2 strings");
        String s1 = br.readLine();
        String s2 = br.readLine();

        int m = s1.length();
        int n = s2.length();
        System.out.println(new Solver().make_equal_dp(s1, s2, m, n));
    }
}

class Solver {
    int make_equal(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return make_equal(s1, s2, m - 1, n - 1);
        } else {
            // Adding last character of s2 in s1
            // Removing last character of s1
            // Replacing last character of s1 with last char of s2

            int temp = Math.min(make_equal(s1, s2, m, n-1), make_equal(s1, s2, m-1, n));
            return 1 + Math.min(temp, make_equal(s1, s2, m-1, n-1));
        }
    }

    int make_equal_dp(String s1, String s2, int m, int n){
        int [][]dp = new int[m+1][n+1];
        for(int i=0; i<=n; i++)
            dp[0][i] = i; // Assuming string TO CONVERT is empty, i = no. of additions on s1
        for(int i=0; i<=m; i++)
            dp[i][0] = i; // Assuming string CONVERTING TO is empty, i = no. of deletions from s1

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int temp = Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], temp);
                }
            }
        }
        return dp[m][n];
    }
}
