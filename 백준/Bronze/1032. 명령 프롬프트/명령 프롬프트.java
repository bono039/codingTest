import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for(int i = 0 ; i < N ; i++) {
		    str[i] = br.readLine();
		}
		
		if(N == 1) {
		    System.out.println(str[0]);
		    return;
		}
		
		for(int i = 0 ; i < str[0].length() ; i++) {
		    boolean isSame = true;
		    int idx = 0;
		    for(int j = 0 ; j < N - 1 ; j++) {
		        if(str[j].charAt(i) != str[j + 1].charAt(i)) {
		            isSame = false;
                    idx = j;
		            sb.append("?");
		            break;
		        }
		    }
		    
		    if(isSame) sb.append(str[idx].charAt(i));
		}
		
		System.out.println(sb);
	}
}
