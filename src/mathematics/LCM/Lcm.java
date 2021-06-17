package mathematics.LCM;

import mathematics.HCF.Hcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lcm {
    public static void main(String args[]) throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        System.out.println("Enter 2 nos to find LCM for");
        String input = br.readLine();
        String words[] = input.split(" ");
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[1]);

        System.out.println(new Solver().lcm_optimized(a, b));
    }
}

class Solver{
    int lcm_brute(int a, int b){
        for (int i=Math.max(a, b); ; i++){
            if (i%a==0 && i%b==0) return i;
        }
    }

    /**
     *
     * We call hcf func() with a time complexity of Θ(log(min(a, b)))
     * And use the formula:
     * ---> a * b = lcm(a, b) * hcf(a, b)
     */
    int lcm_optimized(int a, int b){
        return (a*b)/hcf(a,b);
    }

    int hcf(int a, int b){
        if (b==0) return a;
        return hcf(b, a%b);
    }


}
