import java.util.*;
import java.io.*;

public class Main {
    static int white = 0, blue = 0;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        partition(0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    private static void partition(int row, int col, int size) {
        if(colorChk(row, col, size)) {
            if(map[row][col] == 0)  white++;
            else                    blue++;
            
            return;
        }
        
        int newSize = size / 2;
        partition(row,           col,           newSize);   // 좌측상단
        partition(row,           col + newSize, newSize);   // 좌측하단
        partition(row + newSize, col,           newSize);   // 우측상단
        partition(row + newSize, col + newSize, newSize);   // 우측하단
    }
    
    private static boolean colorChk(int row, int col, int size) {
        for(int i = row ; i < row + size ; i++) {
            for(int j = col ; j < col + size ; j++) {
                if(map[i][j] != map[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}