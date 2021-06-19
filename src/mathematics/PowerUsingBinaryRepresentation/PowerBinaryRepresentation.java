package mathematics.PowerUsingBinaryRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Type of Ques: WAP to find A raised to power B (A^B) in less than O(log n) Space Complexity [**Required SC: O(1)]
public class PowerBinaryRepresentation {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter Number A to be raised to power B");
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().BinaryRepresentation(input[0], input[1]));
    }
}

class Solver{
    /**
     * @param x
     * @param n
     * @return x^n
     * Logic:
     * If x = 3, n = 10, We need to find 3^10
     *
     * Rule:
     * Any no. raised to a power can be represented as that multiplication of that no. raised to powers of 2, For eg:
     * 3^10 = 3^8 * 3^2
     * 3^19 = 3^16 * 3^2 * 3^1
     *
     * Algo:
     * Calculate binary of n, eg 10 = 1010
     * Move from LSB to MSB (Left to Right)
     * For every bit, store value of count as x^x, count = x^x;
     * For every 1 bit, multiply result with count
     * Once reached MSB, return result
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1) -> More Efficient than Iterative process to find power
     */
    int BinaryRepresentation(int x, int n){
        int res = 1;
        while(n>0){ // If MSB = 0, break
            if(n%2 == 1){ // If Current Bit = 1, multiply x with result
                res = res*x;
            }
            x = x*x; // Incrementing power of x
            n=n>>1; // Shifting bits by 1 to right
        }
        return res;
    }
}
