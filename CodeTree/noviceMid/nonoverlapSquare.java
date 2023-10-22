import java.util.*;
import java.io.*;
 
public class Main {
    static final int OFFSET = 1000;
    static int[][] rect = new int[2001][2001];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 각 직사각형 영역에 대해 숫자 집어넣기 (x1, y1) (x2, y2)
        for(int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
 
            // 직사각형 A, B 붙이기
            if(i < 2) {
                paint(i + 1, x1 + OFFSET, y1 + OFFSET, x2 + OFFSET, y2 + OFFSET);
            }
            // 직사각형 M 붙이기 (이미 1인 구간이라면, 0으로 바꾸기)
            else {
                paint(0, x1 + OFFSET, y1 + OFFSET, x2 + OFFSET, y2 + OFFSET);
            }
        }
 
        int cnt = 0;
        for(int i = 0 ; i < 2000 ; i++) {
            for(int j = 0 ; j < 2000 ; j++) {
                //System.out.print(rect[i][j] + " ");
                if(rect[i][j] != 0)
                    cnt++;
            }
            //System.out.println();
        }
        System.out.println(cnt);   
    }
 
    // 직사각형 붙이는 메소드
    private static void paint(int num, int x1, int y1, int x2, int y2) {
        for(int i = x1 ; i < x2 ; i++) {
            for(int j = y1 ; j < y2 ; j++) {
                rect[i][j] = num;
            }
        }
    }
}
