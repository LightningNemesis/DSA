/* Given an array which has even occurrence of elements and only 1 element that occurs odd
   no. of times, WAP to print the element with odd occurrence count.

   i/p: arr[] = {3, 3, 5, 5, 5, 6, 7, 6, 7}
   o/p: 3
 */

/*
We use regular expression: "\\s*,\\s*"
Which means, take into account infinite amount of whitespace on LEFT, followed by a COMMA, followed by infinite amount
of whitespace on RIGHT
Using this regular expression, we can split the input string containing elements separated by comma, into array elements.
More info on http://www.regular-expressions.info/tutorialcnt.html
 */

package bit_magic.odd_occurring_1_time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class odd_occurring_1_time {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array input");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solver().find_odd_occurrence_using_XOR(arr, arr.length));
    }

}

class Solver {
    /**
     * Time complexity: O(n^2) ---> LARGE TIME FOR HUGE N
     * Space complexity: O(1)
     *
     * @param arr
     * @param n
     * @return no. occurring odd no. of times
     */
    int naive_approach(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) count++;
            }
            if (count % 2 != 0) res = arr[i]; // arr[i] has occurred odd times
        }
        return res;
    }

    /**
     * We use the properties of XOR operator to find the odd occurrence:
     * x^0 = x ---- U
     * x^x = 0 ---- U
     * x^y = y^x ---- U
     * x^(y^x) = (x^y)^z (Associative)
     * x^y = y^x (Commutative)
     * <p>
     * Time complexity: O(n) ---> EFFICIENT
     * Space complexity: O(1)
     *
     * @param arr
     * @param n
     * @return no. occurring odd no. of times
     */
    int find_odd_occurrence_using_XOR(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
}
