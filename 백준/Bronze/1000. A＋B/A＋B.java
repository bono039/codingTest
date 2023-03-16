import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    
	    bw.write(A+B+"\n");
	    bw.flush();
	    bw.close();
	}
}