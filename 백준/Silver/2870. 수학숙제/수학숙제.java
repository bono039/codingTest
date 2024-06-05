import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static List<BigInteger> list = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    while(N --> 0) {
	        String str = br.readLine();
	        getNum(str);
	    }
	    
	    Collections.sort(list);
	    
	    StringBuilder sb = new StringBuilder();
	    for(BigInteger i : list) {
	        sb.append(i).append("\n");
	    }
	    System.out.println(sb.toString());
	}
	
	private static void getNum(String str) {
	    String tmp = "";
	        
        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            
            if(Character.isDigit(c)) {
                tmp += c;
            }
            else {
                if(tmp != "") {
                    list.add(new BigInteger(tmp));
                    tmp = "";
                }
                else {
                    tmp = "";
                }	                
            }
        }
        
        if(tmp != "") {
            list.add(new BigInteger(tmp));
        }
	}
}
