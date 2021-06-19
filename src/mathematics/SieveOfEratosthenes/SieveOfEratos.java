package mathematics.SieveOfEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SieveOfEratos {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter limit upto which we need to print prime numbers");
        int limit = Integer.parseInt(br.readLine());
        new Solver().PrimeSeriesUsingSieve(limit);
    }
}

class Solver {
    /**
     * @param n - Print prime numbers <= n
     * Time Complexity = O(n(log log n))
     * Space complexity = O(1)
     */
    void PrimeSeriesUsingSieve(int n) {
        if (n <= 1) System.out.println("No Prime nos. upto " + n);
        Boolean[] arr = new Boolean[n + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i <= n; i ++) {
            if (arr[i]==true) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }
    }
}
