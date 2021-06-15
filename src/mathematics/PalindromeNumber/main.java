package mathematics.PalindromeNumber;

import java.io.*;

public class main {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter a no. to check for palindrome");
        int num = Integer.parseInt(br.readLine());
        System.out.println(new PalindromeChecker().isPalindrome(num));
    }
}

class PalindromeChecker{
    // Time complexity: Θ(log n)
    boolean isPalindrome(int n){
        int new_num = 0, old_num = n;
        while(n!=0) {
            new_num *= 10;
            new_num += n % 10;
            n /= 10;
        }
        return new_num==old_num;
    }
}
