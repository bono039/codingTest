import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		while(true) {
		    String str = br.readLine();
		    if(Integer.parseInt(str) == 0) {
		        System.out.println(answer);
		        return;
		    }
		    
		    StringBuilder sb = new StringBuilder(str);
		    answer.append(Integer.parseInt(sb.toString()) == Integer.parseInt(sb.reverse().toString()) ? "yes" : "no").append("\n");
		}
	}
}