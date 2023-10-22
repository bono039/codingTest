import java.util.*;
import java.io.*;
 
public class Main {
    static final int OFFSET = 100;
 
    static int N, answer;
    static int[][] map = new int[201][201];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
        while(N-->0) {
            st = new StringTokenizer(br.readLine(), " ");
 
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
 
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
 
            getArea(x1 + OFFSET, y1 + OFFSET, x2 + OFFSET, y2 + OFFSET);    // 사각형 색칠하기
        }
        
        answer = 0;
        for(int i = 0 ; i < map.length  ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                //System.out.print(map[i][j] + " ");
                if(map[i][j] == 1) {
                    answer++;
                }
            }
            //System.out.println();
        }
        System.out.println(answer);
    }
 
    // 사각형 색칠 메소드 -> 범위 : (x1, y1) ~ (x2 - 1 , y2 - 1)
    private static void getArea(int x1, int y1, int x2, int y2) {
        for(int i = x1 ; i < x2 ; i++) {
            for(int j = y1 ; j < y2 ; j++) {
                map[i][j] = 1;
            }
        }
    }
}
