import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       int c = Integer.parseInt(st.nextToken());
       int d = Integer.parseInt(st.nextToken());

       int time1 = a * 60 + b;
       int time2 = c * 60 + d;

       System.out.println(time2 - time1);
    }
}
