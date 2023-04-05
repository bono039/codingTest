import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i <= 30 ; i++) {
            list.add(i);
        }
        
        for(int i = 0 ; i < 28 ; i++) {
            Integer num = Integer.parseInt(br.readLine()); 
            list.remove(num);
        }
        
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
}