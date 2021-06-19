package mathematics.DivisorsOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisorsOfNumber {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to print divisors for");
        int n = Integer.parseInt(br.readLine());
        new Solver().PrintDivisors(n);
    }
}

class Solver {
    /**
     * @param n
     * Prints all divisors of n
     * Time Complexity: O(n^0.5)
     * Space Complexity: O(1)
     */
    void PrintDivisors(int n) {
        int i;
        //Printing all divisors <= Square root of n
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) System.out.print(i + " ");
        }
        // Printing all divisors > Square root of n
        for (i = i - 1; i > 0; i--) {
            if (n % i == 0 && i*i!=n) System.out.print((n / i) + " ");
        }
    }
}
