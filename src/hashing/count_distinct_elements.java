/**
 * WAP to print the count of distinct elem,ents in the array
 * ip: {1,10,2,3,5,5}
 * op: 5
 */

package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class count_distinct_elements {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter array to check for distinct elements count");
        int[] arr = Arrays.stream(br.readLine().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();

        // Use this for naive solver
        System.out.println(new naive_solver().count_distinct(arr));

        // Use this for hashing solver
        //System.out.println(new hashing_solver().count_distinct(arr));
    }
}

class naive_solver{
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param arr
     * @return
     */

    int count_distinct(int arr[]){
        int unique_count = 0;
        for(int i=0; i<arr.length; i++){
            boolean check_distinct = true;
            for(int j=0; j<i; j++){
                if(arr[j]==arr[i]){
                    check_distinct = false;
                    break;
                }
            }
            if(check_distinct==true) unique_count++;
        }
        return unique_count;
    }
}

class hashing_solver{
    /**
     * Time Complexity: O(n) -> We need to iterate through all n elements in the array, only unique ones get added though
     * Space Complexity: O(n) -> Worst case: all n elements are unique
     *
     * @param arr
     * @return count of distinct elements
     */
    int count_distinct(int[] arr){
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<Integer>(n); // creating a hashset of same size as array (Worst case: all elements unique)
        for(int i:arr){
           hs.add(i);
        }
        printSet(hs);
        return hs.size(); // SIze of hashset is the ni. of unique elements in the array
    }

    // Works only if we pass an array of Integer interface elements(non primitive), like ArrayList
    // won't work for array of primitives, arr[]
    int count_distinct_eff(Integer[] arr){
        HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(arr));
        printSet(hs);
        return hs.size();
    }

    void printSet(HashSet hs){
        System.out.println(hs);
    }
}
