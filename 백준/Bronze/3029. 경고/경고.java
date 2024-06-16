import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] now = br.readLine().split(":");
	    int h1 = Integer.parseInt(now[0]);
	    int m1 = Integer.parseInt(now[1]);
	    int s1 = Integer.parseInt(now[2]);
	    
	    String[] time = br.readLine().split(":");
	    int h2 = Integer.parseInt(time[0]);
	    int m2 = Integer.parseInt(time[1]);
	    int s2 = Integer.parseInt(time[2]);

	    if(h1 == h2 && m1 == m2 && s1 == s2) {
	        System.out.println("24:00:00");
	        return;
	    }
	    
	    int[] answer = new int[3];
	    
	    if(s2 < s1) {
	        answer[2] = s2+60 - s1;
	        m2--;
	    }
	    else {
	        answer[2] = s2 - s1;
	    }
	    
	    if(m2 < m1) {
	        answer[1] = m2+60 - m1;
	        h2--;
	    }
	    else {
	        answer[1] = m2 - m1;
	    }
	    
	    if(h2 < h1) {
	        answer[0] = h2+24 - h1;
	    }
	    else {
	        answer[0] = h2 - h1;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    if(answer[0] < 10) {
	        sb.append("0");
	    }
	    sb.append(answer[0] + ":");
	    
	    if(answer[1] < 10) {
	        sb.append("0");
	    }
	    sb.append(answer[1] + ":");
	    
	    if(answer[2] < 10) {
	        sb.append("0");
	    }
	    sb.append(answer[2]);
	    
	    System.out.println(sb.toString());
	}
}