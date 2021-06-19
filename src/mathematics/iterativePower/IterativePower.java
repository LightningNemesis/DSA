package mathematics.iterativePower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Type of Ques: WAP to find A raised to power B, without using Math.pow or any other exponent computing function
public class IterativePower {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter Number A to be raised to power B");
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().optimized_power(input[0],input[1]));
    }
}

class Solver{
    /**
     *
     * @param a
     * @param b
     * @return a^b
     *
     * Time Complexity: O(b)
     * Space Complexity: O(1)
     */
    int iterative_power(int a, int b){ // Brute Force method
        int res = 1;
        while(b!=0){
            res *= a;
            b--;
        }
        return res;
    }

    /**
     *
     * @param a
     * @param b
     * @return a^b
     *
     * Time Complexity: O(log b)
     * Space Complexity: O(log b) -> Depends on the height of the tree
     */
    int optimized_power(int a, int b){
        if(b==0) return 1;
        int temp = optimized_power(a, b/2);
        temp = temp*temp;
        if(b%2==0) return temp;
        else return temp*a;
    }
}
