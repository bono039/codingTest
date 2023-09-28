import java.util.*;
import java.io.*;

public class Main {
    private static final int MAX_DIGIT = 20;

    private static int a, b, cnt;
    private static String n;
    private static int[] digits = new int[MAX_DIGIT];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        String n = br.readLine();

        // 1. a진수로 표현된 n을 십진수로 변환
        int num = 0;
        for(int i = 0 ; i < n.length() ; i++) {
            num = num * a + (n.charAt(i) - '0');
        }
        //System.out.println(num);


        // 2. 10진수로 표현된 n을 b진수로 변환
        cnt = 0;
        while(true) {
            if(num < b) {
                digits[cnt++] = num;
                break;
            }

            digits[cnt++] = num % b;
            num /= b;
        }       

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i = cnt - 1 ; i >= 0 ; i--)
            sb.append(digits[i]);

        System.out.println(sb.toString());
    }
}
