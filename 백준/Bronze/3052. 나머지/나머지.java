import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < 10 ; i++) {
            Integer num = Integer.parseInt(br.readLine()); 
            set.add(num % 42);
        }
		System.out.println(set.size());
	}
}