import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String word = br.readLine();
	    bw.write(word.length()+"\n");
	    bw.flush();
	}
}