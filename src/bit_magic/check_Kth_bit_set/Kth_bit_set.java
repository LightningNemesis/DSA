package bit_magic.check_Kth_bit_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kth_bit_set {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter No. and bit position to check");
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new Solver().set_check_right_shift(n[0], n[1]);
    }

}

class Solver{
    void set_check_left_shift(int n, int k){
        if((1<<(k-1) & n)!=0) System.out.println("Yes");
        else System.out.println("No");
    }

    void set_check_right_shift(int n, int k){
        if(((n>>(k-1))&1) !=0) System.out.println("Yes");
        else System.out.println("No");
    }
}
