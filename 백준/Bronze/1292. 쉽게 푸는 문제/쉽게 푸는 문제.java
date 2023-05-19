import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1 ; i <= B ; i++) {
		    // 숫자 n을 n번 채우기
		    for(int j = 0 ; j < i ; j++) {
		        list.add(i);
		    }
		}
		
		int sum = 0;
		for(int i = A-1 ; i < B ; i++) {
		    sum += list.get(i);
		}
		System.out.println(sum);
	}
}