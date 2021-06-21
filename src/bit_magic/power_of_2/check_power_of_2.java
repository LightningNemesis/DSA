package bit_magic.power_of_2;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class check_power_of_2 {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to check if it is a power of 2");
        int input = Integer.parseInt(br.readLine());
        System.out.println(new Solver().brian_k_approach(input));
    }
}

class Solver{
    /**
     * Logic:
     * Using Brian Kerningam's algorithm, n & (n-1) returns no. with rightmost set bit removed
     * Since, power of 2 will have only 1 set bit, hence o/p will be 0
     *
     * Time Complexity: theta(1)
     * Space Complexity: theta(1)
     *
     * @param n
     * @return true or false depending no. is a power of 2 or not
     *
     * i/p: 8
     * o/p: true
     *
     * i/p: 6
     * o/p: false
     */
    boolean brian_k_approach(int n){
        return (n!=0 && ((n&(n-1))==0));
    }
}
