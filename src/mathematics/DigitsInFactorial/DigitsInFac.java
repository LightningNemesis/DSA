package mathematics.DigitsInFactorial;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsInFac {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to find digits in factorial");
        int num = Integer.parseInt(br.readLine());
        System.out.println(new Solver().digits_in_fac_count(num));
    }
}

class Solver {
    int digits_in_fac_count(int n) {
        double digits = 0;
        if (n < 0) return -1;
        if (n <= 1) return 1;
        for (int i = 2; i <= n; i++) {
            digits += Math.log10(i); // using the formula: log10(!N) = log10(1) * log10(2) * ... log10(n)
        }
        return (int)digits+1;
    }
}
