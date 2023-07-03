import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        boolean[] noSelf = new boolean[10001];

        for(int i = 1 ; i <= 10000 ; i++) {
            int newNum = getNewNum(i);
            
            if(newNum <= 10000) {
                noSelf[newNum] = true;
            }
        }
        
        for(int i = 1 ; i < noSelf.length ; i++) {
            if(!noSelf[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
    
    private static int getNewNum(int num) {
        int newNum = num;
        
        while(num > 0) {
            newNum += num % 10;
            num /= 10;
        }
        return newNum;
    }
}
