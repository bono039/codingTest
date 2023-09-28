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

        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        int day1 = b;
        int day2 = d;

        for(int i = 0 ; i < a ; i++) {
            day1 += days[i];
        }

        for(int i = 0 ; i < c ; i++) {
            day2 += days[i];
        }

        System.out.println(day2 - day1 + 1);
    }
}
