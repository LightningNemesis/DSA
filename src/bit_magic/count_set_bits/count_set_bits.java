package bit_magic.count_set_bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class count_set_bits {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter no. to find count of set bits in");
        int input = Integer.parseInt(br.readLine());
        System.out.println(new Solver().lookup_table_approach(input));
    }

}

class Solver {
    int[] table = new int[256];
    /**
     * @param n
     * @return no. of set bits in n
     *
     * Time Complexity: O(size of integer:32 or 64)
     * Space Complexity: O(1)
     */
    int naive_approach(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }

    /**
     * Better optimized approach
     *
     * @param n
     * @return no. of set bits in n
     *
     * Time Complexity: O(no. of set bits)
     * Space Complexity: O(1)
     */
    int brian_kerningam_algorithm(int n){
        int res = 0;
        while(n>0){
            n=n&(n-1);
            res++;
        }
        return res;
    }



    void initialize_lookup_table(){
        table[0] = 0;
        for(int i=1; i<=255; i++){
            table[i] = (i&1) + table[i/2];
        }
    }

    /**
     * MOST EFFICIENT APPROACH
     *
     * @param n
     * @return no. of set bits in n
     *
     * Time Complexity: O(1) If we have the lookup table initialized beforehand
     * Space Complexity: O(1)
     */
    int lookup_table_approach(int n){
        initialize_lookup_table();
        int res = 0;
        res += table[n&0xff];
        n = n >>8;
        res += table[n&0xff];
        n = n >>8;
        res += table[n&0xff];
        n = n >>8;
        res += table[n&0xff];
        return res;
    }
}