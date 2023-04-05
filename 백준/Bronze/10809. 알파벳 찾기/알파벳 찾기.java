import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		String s = br.readLine();
		
		for(int i = 0 ; i < s.length() ; i++) {
		    if(s.contains(String.valueOf(s.charAt(i)))) {
		        if(arr[s.charAt(i) - 'a'] == -1) {
		            arr[s.charAt(i) - 'a'] = i;
		        }
		    }
		}
		
		for(int i : arr) {
		    System.out.print(i + " ");
		}
	}
}