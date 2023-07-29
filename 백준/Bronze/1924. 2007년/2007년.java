import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        int mm = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());
        
        int days = 0;
        for(int i = 1 ; i < mm ; i++) {
            days += month[i];
        }
        days += dd;
        
        String answer = " ";
        switch(days % 7) {
            case 1:
                answer = "MON";    break;
            case 2:
                answer = "TUE";    break;
            case 3:
                answer = "WED";    break;
            case 4:
                answer = "THU";    break;
            case 5:
                answer = "FRI";    break;
            case 6:
                answer = "SAT";    break;
            case 0:
                answer = "SUN";    break;
        }
        
        System.out.println(answer);
    }
}