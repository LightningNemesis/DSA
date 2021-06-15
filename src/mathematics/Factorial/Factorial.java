package mathematics.Factorial;

import java.io.*;
import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to find factorial for");
        int num = Integer.parseInt(br.readLine());
        System.out.println(new Solver().fact_iterative(num));
    }
}

class Solver{
    // Iterative solution
    // Time complexity: Θ(n)
    // Space complexity: Θ(1)
    BigInteger fact_iterative(int n){
        BigInteger f = BigInteger.ONE;
        while(n!=0){
            f = f.multiply(BigInteger.valueOf(n));
            n--;
        }


        return f;
    }

    // Recursive solution
    // Time complexity: Θ(n)
    // Space complexity: Θ(n) ----> Here space complexity is greater, due to the function stack which stores all the function calls
    long fact_recursive(int n){
        if (n==0) return 1;
        return n * fact_recursive(n--);
    }
}
