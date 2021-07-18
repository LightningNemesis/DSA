/**
 * WAP to print the frequency of every element in the array
 * ip: {10,10,2,3,5,5}
 * op:
 *
 * 10 2
 * 2 1
 * 3 1
 * 5 2
 *
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class frequency_of_elements {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array to count frequencies");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();

        //new hashing_solver_frequency_of_elements().frequency(arr);
        new naive_solver_frequency_of_elements().frequency(arr);

    }
}

class naive_solver_frequency_of_elements{
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param arr
     */
    void frequency(int [] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            // Section ensures we don't print frequency multiple times, like 10:2, 10:2 for ip->{10, 10}
            boolean seenBefore = false;
            for(int j = 0; j<i; j++) {
                if (arr[j] == arr[i]) seenBefore = true;
            }
            if(seenBefore) continue;

            // Reached here, meaning element has appeared first time
            int count = 1;
            for(int j=i+1; j<n; j++) {
                if (arr[i] == arr[j]) count++;
            }
            System.out.println(arr[i] +": "+ count);
        }
    }
}

class hashing_solver_frequency_of_elements{
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param arr
     */
    void frequency(int []arr){
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(n);
        for(int i:arr){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }
            else hm.put(i, 1);
        }
        for(Map.Entry e: hm.entrySet()){ //Iterator
            System.out.println(e.getKey() +": "+e.getValue());
        }
    }
}

