import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		    String str = br.readLine();
		    
		    if(str.equals("END")) break;
		    
		    StringBuilder sb1 = new StringBuilder(str);
		    sb.append(sb1.reverse()).append("\n");
		}
		
		System.out.println(sb);
	}
}
