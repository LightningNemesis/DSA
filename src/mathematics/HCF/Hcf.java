package mathematics.HCF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hcf {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter 2 nos. to find GCD");
        String str = br.readLine();
        String words[] = str.split(" ");
        int a = Integer.parseInt(words[0]), b = Integer.parseInt(words[1]);
        System.out.println(new Solver().HCF_recursive(a, b));
    }
}

class Solver {
    int HCF_brute_force(int a, int b) {
        int min = Math.min(a, b);
        int i = 0;
        for (i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) break;
        }
        return i;
    }

    /**
     * Time complexity: Θ(min(a, b))
     * Space complexity: Θ(1)
     **/

    int HCF_recursive(int a, int b) {
        if (b == 0)
            return a;
        return HCF_recursive(b, a % b); // a%b will never be greater than b, so no need to check for min or max of a & b
    }
    /*
    Time complexity: Θ(log(min(a, b)))
    Space complexity: Θ(log(min(a, b))s)

    We use the Euclidean Algorithm, and optimize it with the logic
    -> Base case for recursion will be obtained when 'b' becomes 0, i.e. current 'a'(previous 'b')
       has divided previous 'a'
    Now since 'b' will always be greater than 'a', after the 1st recursion call,
    We are only interested in the value of current 'a'(previous 'b') &
    we return 'a'
     */

}

