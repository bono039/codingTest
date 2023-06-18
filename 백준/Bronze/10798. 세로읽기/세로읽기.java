import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] words = new char[5][15];
		int max = 0;
        
		for(int i = 0 ; i < 5 ; i++) {
		    String str = br.readLine();
		    max = Math.max(max, str.length());
		    
		    for(int j = 0 ; j < str.length() ; j++) {
		        words[i][j] = str.charAt(j);
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int j = 0 ; j < max ; j++) {
		    for(int i = 0 ; i < 5 ; i++) {
		        if(words[i][j] == '\0') continue;
		        sb.append(words[i][j]);
		    }
		}
		System.out.println(sb);
	}
}