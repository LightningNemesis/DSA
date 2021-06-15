/*
Counting the no. of digits in a number in 3 ways:

1. Iterative (Using a while loop) -> Θ(log10(n))
2. Recursive (Using recursive calls) -> Θ(log10(n))
3. In Constant time (Using formula: floor(log10(n) +1)) -> Θ(1) ----> MOST EFFICIENT
*/


package mathematics.CountDigits;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import static java.lang.System.out;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        final int num = Integer.parseInt(br.readLine());
        final Instant start = Instant.now();
        final int result = new CountDigits().count_recursive(num);
        final Instant end = Instant.now();
        out.println(result);
        out.println("Time taken: " + Duration.between(start, end));
    }
}

class CountDigits {
    // Running a loop & replacing n with n/10, incrementing count in each cycle
    // Time complexity: Θ(log n)
    public int count_iterative(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    // Making a recursive call [@params: n/10 for each cycle], until n==0
    // Time complexity: Θ(log n)
    public int count_recursive(int n) {
        if (n == 0) return 0;
        return 1 + count_recursive(n / 10);
    }

    //	If n = 123,
    //	(log10 123) + 1 = 2.08 + 1 = 3.08
    //	floor(3.08) = 3
    // Time complexity: Θ(1) ----> MOST EFFICIENT
    public int count_constant(int n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }
}


