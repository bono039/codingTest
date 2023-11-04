import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,0,1,0};   // 북서남동 (행과 열 기준)
    static int[] dy = {0,-1,0,1};

    static char[] arr;
    static int x,y;
    static int dir,time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 'F') {
                x += dx[dir];
                y += dy[dir];
            }
            else if(arr[i] == 'L') {
                dir = (dir + 1) % 4;
            }
            else if(arr[i] == 'R') {
                dir = (dir - 1 + 4) % 4;
            }
            time++;

            if(x == 0 && y == 0) {
                System.out.println(time);
                return;
            }
        }
        
        System.out.println(-1);
    }
}
