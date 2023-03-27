import java.util.*;
import java.io.*;

public class Main {
    public static int getGCD(int a, int b) {
        if(b == 0) return a;
        else       return getGCD(b, a % b);
    }
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int ja1 = Integer.parseInt(st.nextToken());
		int mo1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int ja2 = Integer.parseInt(st.nextToken());
		int mo2 = Integer.parseInt(st.nextToken()); 
		
		int bunja = ja1 * mo2 + ja2 * mo1;
		int bunmo = mo1 * mo2;
		
		// 최대공약수 구하기
		int gcd = getGCD(bunja, bunmo);
		System.out.println(bunja/gcd + " " + bunmo/gcd);
	}
}