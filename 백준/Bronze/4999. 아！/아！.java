import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String jaehwan = br.readLine();
		String doctor = br.readLine();
		
		System.out.println(jaehwan.length() < doctor.length() ? "no" : "go");
	}
}