import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long up   = Long.parseLong(st.nextToken());
		long down = Long.parseLong(st.nextToken());
		long goal = Long.parseLong(st.nextToken());
        
        long day = (goal - down) / (up - down);
        if((goal - down) % (up - down) != 0) {
            day++;
        }
        
        System.out.println(day);
	}
}
