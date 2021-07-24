package DP.mth_fibonacci_no;

import DP.InputHandler;

import java.io.IOException;
import java.util.Arrays;

/*
class inputHandler {
    static InputStreamReader ir = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(ir);
}
*/

public class mth_fibonacci_no extends InputHandler {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter which which fibonacci no. required");
        int m = Integer.parseInt(br.readLine());

        //Memoization
        System.out.println("Memoization: " + new memoization_solver(m).m_th_fibonacci(m));

        //Tabulation
        System.out.println("Tabulation: " + new tabulation_solver(m).m_th_fibonacci(m));

    }
}

class memoization_solver {
    /**
     * IT USES A TOP DOWN APPROACH
     * DIMENSION OF MEM_ARR -> param count (Here only 1, m)
     * SIZE OF MEM_ARR -> range of param (Here m ranges from 0 - m)
     *
     * TC: O(2n-1) -> O(m)
     * SC: O(m)
     */
    int mem_arr[];

    memoization_solver(int m) {
        mem_arr = new int[m + 1];
        Arrays.fill(mem_arr, -1);
        mem_arr[0] = 0;
        mem_arr[1] = 1;
    }

    int m_th_fibonacci(int m) {
        if (mem_arr[m] == -1) {
            mem_arr[m] = m_th_fibonacci(m - 1) + m_th_fibonacci(m - 2);
        }
        return mem_arr[m];
    }
}

class tabulation_solver extends memoization_solver {
    /**
     * IT USES A BOTTOM UP APPROACH
     *
     * TC: O(m) // Generally faster than memoization
     * SC: O(m)
     */
    //USES A BOTTOM UP APPROACH
    tabulation_solver(int m) {
        super(m);
    }

    int m_th_fibonacci(int m) {
        for (int i = 2; i <= m; i++) {
            mem_arr[i] = mem_arr[i - 1] + mem_arr[i - 2];
        }
        return mem_arr[m];
    }

}
