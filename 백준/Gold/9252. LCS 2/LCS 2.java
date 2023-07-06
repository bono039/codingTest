import java.util.*;
import java.io.*;
 
public class Main {
    private static long[][] DP;                 // 2차원 점화식 배열
    private static ArrayList<Character> Path;   // LCS 저장 리스트
    private static char[] A;
    private static char[] B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        
        DP = new long[A.length + 1][B.length + 1];
        
        Path = new ArrayList<>();
        
        // 2차원 점화식 배열 채우기
        for(int i = 1 ; i <= A.length ; i++) {
            for(int j = 1 ; j <= B.length ; j++) {
                // 같은 문자열일 때 왼쪽 대각선 값 + 1
                if(A[i - 1] == B[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }
                // 다르면 왼쪽과 위쪽 값 중 큰 수
                else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[A.length][B.length]);
        
        // LCS 출력
        getText(A.length, B.length);
        for(int i = Path.size() - 1 ; i >= 0 ; i--) {   // 역추적
            System.out.print(Path.get(i));
        }
        System.out.println();
        br.close();
    }
    
    // LCS 출력 메소드
    private static void getText(int r, int c) {
        if(r == 0 || c == 0) return;
        
        // 같으면 LCS에 기록하고 왼쪽 위로 이동
        if(A[r - 1] == B[c - 1]) {
            Path.add(A[r - 1]);
            getText(r - 1, c - 1);
        }
        else {
            // 다르면 왼쪽과 위쪽 중 큰 수로 이동
            if(DP[r - 1][c] > DP[r][c - 1])
                getText(r - 1, c);
            else
                getText(r, c - 1);
        }
    }
}
