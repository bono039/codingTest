import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        String cmd = br.readLine();
        for(int i = 0 ; i < str.length ; i++) {
            if(cmd.contains(str[i])) {
                cmd = cmd.replace(str[i], ".");
            }
        }
        
        System.out.println(cmd.length());
    }
}