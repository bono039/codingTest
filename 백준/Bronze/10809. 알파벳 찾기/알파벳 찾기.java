import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[26];
		Arrays.fill(num, -1);
		
		String str = sc.nextLine();
		
		for(int i=0 ; i < str.length() ; i++) {
		    char ch = str.charAt(i);
		    
		    if(num[ch - 'a'] == -1) {
		        num[ch - 'a'] = i;
		    }
		}
		
		for(int i : num) {
		    System.out.print(i + " ");
		}
	}
}