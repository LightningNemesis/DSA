package mathematics.Prime;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to check for prime and print prime factors");
        int input = Integer.parseInt(br.readLine());
        primeOperations obj = new primeOperations();
        System.out.println(input+ " is a prime number? "+ obj.checkPrime(input));
        obj.primeFactors(input);

    }

}

class primeOperations {
    /**
     * @param n
     * @return true | false
     * Depending on prime or not prime
     */
    boolean checkPrime(int n) {
        if (n <= 1) return false; // corner case: numbers <=1 are not prime numbers, neither are they non prime numbers
        if (n == 2 || n == 3) return true; // checking for smallest prime factors
        if (n % 2 == 0 || n % 3 == 0) return false; // checking for individual multiples of smallest prime nos
        // Note: Since divisors occur in pair,
        // one of the nos. in the pair will always be <= Sqrt(n)
        for (int i = 5; i * i <= n; i = i + 6) { // starting with 5, increment by 6 till i^2 <=n
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        /** At this point, we have checked if one of the divisor pairs is not:
         * less than or equal to 1
         * not 2 or 3
         * not a multiple of 2 or 3
         * not a multiple of a prime number, less than equal to square root of n (one of the divisor pairs)
         */
        return true;
    }

    // Print all the prime factors of a number in increasing order
    void primeFactors(int n) {
        if(n<=1) System.out.println("Number is <= 1, no prime factors");
        while(n%2==0) {
            System.out.print(2 + " ");
            n/=2;
        }
        while(n%3==0) {
            System.out.print(3 + " ");
            n/=3;
        }
        for(int i=5; i*i<=n; i+=6){
            while((n%i)==0){
                System.out.print(i + " ");
                n/=i;
            }
            while((n%(i+2))==0){
                System.out.print(i+2 + " ");
                n/=(i+2);
            }
        }
        if(n > 3) System.out.print(n + " ");
    }

}
