import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		String result = recursion(N, "SK");
		System.out.println(result);
	}
	
	static String recursion(int rock, String name) {
	    if(name.equals("SK")) {
	        if(rock - 3 >= 0) {
	            rock -= 3;
	            return recursion(rock, "CY");
	        }
	        else if(rock - 1 >= 0) {
	            rock--;
	            return recursion(rock, "CY");
	        } else if(rock == 0) {
	            return "CY";
	        }
	    }
	    else if(name.equals("CY")) {
	        if(rock - 3 >= 0) {
	            rock -= 3;
	            return recursion(rock, "SK");
	        }
	        else if(rock - 1 >= 0) {
	            rock--;
	            return recursion(rock, "SK");
	        } else if(rock == 0) {
	            return "SK";
	        }
	    }
	    return "";
	}
}