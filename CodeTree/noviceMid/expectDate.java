import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String[] dates = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        int day1 = d1;
        int day2 = d2;

        for(int i = 0 ; i < m1 ; i++) {
            day1 += days[i];
        }
        for(int i = 0 ; i < m2 ; i++) {
            day2 += days[i];
        }

        int diff = (day2 - day1 + 1) % 7;

        // ⚠ 음수 값 처리 ⚠
        if(diff < 0) {
            diff += 7;
        }
        
        System.out.println(dates[diff]);
    }
}
