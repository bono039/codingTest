import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		int[] alphabet = new int[26];
		
		for(int i = 0 ; i < str.length() ; i++) {
		    alphabet[str.charAt(i) - 'A']++;
		}
		
		int max = 0;
		char ch = '?';
		
		for(int i = 0 ; i < alphabet.length ; i++) {
		    if(alphabet[i] > max) {
		        max = alphabet[i];
		        ch = (char) (i + 65);
		        
		    } else if(alphabet[i] == max) {
		        ch = '?';
		    }
		}
		System.out.println(ch);
	}
}