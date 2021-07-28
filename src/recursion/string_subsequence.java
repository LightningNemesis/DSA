package recursion;

import InputHandler.InputHandler;
import java.io.IOException;

public class string_subsequence extends InputHandler {
    public static void main(String[] args)throws IOException{
        System.out.println("Enter string");
        String str = br.readLine();
        int i = 0, len = str.length();
        new solver().subsequence(str, "", 0, len);
    }
}

class solver{
    void subsequence(String str, String curr, int i, int len){
        if(i==len){
            System.out.println(curr);
        }
        else{
            subsequence(str, curr, i+1, len);
            subsequence(str, curr+str.charAt(i), i+1, len);
        }
    }
}
