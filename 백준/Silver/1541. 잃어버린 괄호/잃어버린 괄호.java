import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] str = br.readLine().split("-");
	    
	    int answer = 0;
	    
		for(int i = 0 ; i < str.length ; i++) {
		    int tmp = mySum(str[i]);
		    
		    // 가장 앞에 있는 값만 더함
		    if(i == 0) {
		        answer += tmp;
		    }
		    // 뒷부분은 더한 값들을 뺌
		    else {
		        answer -= tmp;
		    }
		}

		System.out.println(answer);
	}
	
	// 현재 String에 있는 수를 모두 더하는 함수
	static int mySum(String a) {
	    int sum = 0;
	    
	    String[] s = a.split("[+]");
	    
	    for(int i = 0 ; i < s.length ; i++) {
	        sum += Integer.parseInt(s[i]);
	    }
	    return sum;
	}
}