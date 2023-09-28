import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int time1 = 11 * 24 * 60 + 11 * 60 + 11;
        int time2 = a * 24 * 60 + b * 60 + c;

        int diff = time2 - time1;
        System.out.println(diff < 0 ? -1 : diff);
    }
}
