import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] str = br.readLine().split(" ");
        boolean isDown = false;
        
        for(int i = 0 ; i < str.length - 1 ; i++) {
            if(Integer.parseInt(str[i]) > Integer.parseInt(str[i + 1])) {
                isDown = true;
                break;
            }
        }
        
        System.out.println(isDown ? "Bad" : "Good");
    }
}
