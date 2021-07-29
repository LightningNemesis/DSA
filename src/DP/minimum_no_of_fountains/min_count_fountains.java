package DP.minimum_no_of_fountains;

import InputHandler.InputHandler;

import java.io.IOException;
import java.util.Arrays;

public class min_count_fountains extends InputHandler {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter fountain array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        new Solver().tap_count(arr);
    }
}


class Solver {
    void tap_count(int[] fountains) {
        int n = fountains.length;
        int[][] range = new int[n][2];

        int l = Integer.MAX_VALUE, u = Integer.MIN_VALUE;
        /*for(int i=0; i<n; i++){
            range[i][0] = Math.max((i+1)-fountains[i], 1);
            range[i][1] = Math.min((i+1)+fountains[i], n);
        }*/
        for (int i = 0; i < n; i++) {
            range[i][0] = i - fountains[i];
            range[i][1] = i + fountains[i];
            l = Math.min(l, range[i][0]);
            u = Math.max(u, range[i][1]);
        }







        for (int i = 0; i < n; i++)
            System.out.println(range[i][0] + "->" + range[i][1]);
        System.out.println("l-> "+l+" u-> "+u);


    }
}