import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int i=0 ; i < T ; i++) {
	        //String[] str =br.readLine().split(" "); // 공백 분리
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        int R = Integer.parseInt(st.nextToken());
	        String S = st.nextToken();
	        
	        
	        for(int j=0 ; j < S.length() ; j++) {
	            for(int k=0 ; k < R ; k++) {
	                System.out.print(S.substring(j,j+1));
	            }  
	        }
	        System.out.println();
	    }
        
	}
}