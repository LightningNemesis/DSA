package mathematics.TrailingZeroFactorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZeroFac {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to find trailing 0's in factorial");
        int num = Integer.parseInt(br.readLine());
        System.out.println(new Solver().trailing_0_count(num));
    }
}

class Solver{
    int trailing_0_count(int n){
        int res = 0;
        for (int i = 5; i<=n; i*=5){
            res+=n/i;
        }
        return res;
    }

    /*
    Assuming the loop run K times
        5^K <= n
    =>  log(5) 5^K <= log(5) n
    =>  K = log n
    Thus, the time complexity of function is
    O(log n)

    O(log n) < O(n) [finding factorial]
    Hence, it is an efficient approach
     */
}
