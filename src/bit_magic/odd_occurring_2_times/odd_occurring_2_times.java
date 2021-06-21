/* Given an array which has even occurrence of elements and only 2 elements that occur odd
   no. of times, WAP to print the elements with odd occurrence count.

   i/p: arr[] = {3, 3, 5, 5, 5, 4, 6, 7, 6, 7}
   o/p: 3
 */

package bit_magic.odd_occurring_2_times;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class odd_occurring_2_times {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array input");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        new Solver().usingXOR(arr, arr.length);
    }
}

class Solver{
    void naive_method(int[] arr, int n){
        for(int i=0; i<n; i++){
            int count = 0;
            for (int j=0;j<n; j++){
                if(arr[i]==arr[j]) count++;
            }
            if(count%2 != 0) System.out.println(arr[i] + "\t");
        }
    }

    void usingXOR(int[] arr, int n){
        int XOR = 0, res1 = 0, res2 = 0;
        for(int i = 0; i<n; i++){
            XOR = XOR ^ arr[i];
        }
        // Now XOR has all the odd occurrence nos.
        // eg,
        // i/p: {3, 3, 5, 5, 5, 4, 6, 7, 6, 7}
        // XOR = 5 ^ 4

        // We need to find the rightmost set bit in XOR
        int sn = XOR & ~(XOR - 1);

        // Using rightmost set bit, we will split the array into 2 XOR groups
        // each containing 1 odd occurrence element
        for(int i=0; i<n; i++){
            if((arr[i] & sn)!=0) res1 = res1^arr[i];
            else res2 = res2^arr[i];
        }
        System.out.println(res1 + "\t" + res2);
    }
}

