import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
        
        int idx = 0;
        int max = 0;
        for(int i = 0 ; i < 9 ; i++) {
            int num = Integer.parseInt(br.readLine()); 
            
            if(num > max) {
                max = num;
                idx = i + 1;
            }
        }
        
		System.out.println(max);
		System.out.println(idx);
	}
}
