package arrays.rotate_by_D;

import InputHandler.InputHandler;

import java.io.IOException;
import java.util.Arrays;

public class rotate_by_D extends InputHandler {
    public static void main(String[] args)throws IOException {
        System.out.println("Enter array");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter no. of rotations");
        int d = Integer.parseInt(br.readLine());
        new Solution().leftRotate(arr, arr.length, d);
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }
}

class Solution {
    void leftRotate(int[] arr, int n, int d) {
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    int[] reverse(int arr[], int l, int u){
        int temp;
        while(l<u){
            temp = arr[l];
            arr[l] = arr[u];
            arr[u] = temp;
            l++;
            u--;
        }
        return arr;
    }
}