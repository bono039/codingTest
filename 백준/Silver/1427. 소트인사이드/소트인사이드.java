import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
		int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        
	    while(n > 0) {
	        list.add(n % 10);
	        n /= 10;
	    }
	    
	    // 리스트 내림차순 정렬
	    list.sort(Comparator.reverseOrder());
	    
	    int num = 0;
	    for(int i : list) {
	        num *= 10;
	        num += i;
	    }
	    
	    System.out.println(num);
	}
}