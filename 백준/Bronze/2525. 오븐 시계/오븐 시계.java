import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine());
		
		int time = a * 60 + b + c;
		
		int h = time / 60;
		int m = time % 60;
		
		if(h >= 24) {
		    h -= 24;
		}
		
		System.out.println(h + " " + m);
	}
}