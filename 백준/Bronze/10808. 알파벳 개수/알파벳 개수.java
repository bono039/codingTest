import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int[] arr = new int[26];
		String s = br.readLine();
		
		for(int i = 0 ; i < s.length() ; i++) {
		    arr[s.charAt(i) - 'a']++;
		}
        
        for(int i : arr) {
            sb.append(i + " ");
        }
        
        System.out.println(sb.toString().trim());
	}
}