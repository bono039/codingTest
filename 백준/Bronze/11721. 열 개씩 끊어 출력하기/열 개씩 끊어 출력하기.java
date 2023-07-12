import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        
        int idx = 0;
        for(int i = 0 ; i <= str.length() - 10 ; i += 10) {
            sb.append(str.substring(i, i + 10)).append("\n");
            idx = i + 10;
        }
        sb.append(str.substring(idx));
        System.out.println(sb);
    }
}
