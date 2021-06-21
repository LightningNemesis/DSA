/*
WAP to print all the subsets or power sets of a word or number

Sample i/p: "abc"
Sample o/p:

""
"a"
"b"
"ab"
"c"
"ac"
"bc"
"abc"


LOGIC:
Power set of any string can be derived using 2^n
Since each character has 2 options, present or absent
eg for 'a', we can have '' or 'a'

Hence for n characters, we can have 2^n permutations
Using binary representation from 0 to 2^n-1, we can refer to the position of the SET BITS and print the corresponding
characters from the string.
Eg. 010 = "b", 110 = "bc" and so on
 */

package bit_magic.all_subsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class all_subsets {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter string");
        String str = br.readLine();
        new Solver().powerSet(str);
    }
}

class Solver{
    /**
     * Time Complexity: Theta(n*(2^n))
     * Space Complexity: Theta(1)
     *
     * @param str
     */
    void powerSet(String str){
        // Step 1. Get the size of powerSet
        int powerSet = (int)Math.pow(2, str.length());

        // Step 2. Iterate from 0 to powerSet-1, each iteration represents the combination of subset to be printed
        for(int i=0; i<powerSet; i++){
            for(int j=0; j<str.length(); j++){ // visiting each character
                if((i & 1<<j)!=0) System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}
