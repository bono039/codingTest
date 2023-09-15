import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String A = "ABBBDAAA";
        String B = "BADABBDBA";
        
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for(int i = 1 ; i < dp.length ; i++) {
            dp[i][0] = i;
        }
        for(int i = 1 ; i < dp[0].length ; i++) {
            dp[0][i] = i;
        }
        
        for(int i = 1 ; i <= A.length() ; i++) {
            for(int j = 1 ; j <= B.length() ; j++) {
                // 문자열 A의 i번째 글자 == 문자열 B의 j번째 글자인 경우
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                // 다른 경우, 삽입 /삭제
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
            }
        }
        
        System.out.println(dp[A.length()][B.length()]);
    }
}
