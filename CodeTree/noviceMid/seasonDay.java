import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
 
        // 윤년 확인
        boolean isLeapYear = false;
        if ((Y % 4 == 0 && Y % 100 != 0) || (Y % 400 == 0)) {
            isLeapYear = true;
            days[2] = 29;
        }
 
        String answer = "";
 
        if(3 <= M && M <= 5) {
            answer = inRange(D, days[M]) ? "Spring" : "-1";
        }
        else if(6 <= M && M <= 8) {
            answer = inRange(D, days[M]) ? "Summer" : "-1";
        }
        else if(9 <= M && M <= 11) {
            answer = inRange(D, days[M]) ? "Fall" : "-1";
        }
        else {
            answer = inRange(D, days[M]) ? "Winter" : "-1";
        }
 
        System.out.println(answer);
    }
 
    private static boolean inRange(int num, int max) {
        if(num <= max) return true;
        return false;
    }
}
