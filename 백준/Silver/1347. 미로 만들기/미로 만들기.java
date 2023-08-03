import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        
        char[][] map = new char[101][101];
        for(int i = 0 ; i < 101 ; i++) {
            for(int j = 0 ; j < 101 ; j++) {
                map[i][j] = '#';
            }
        }
        
        int startX, startY, minX, minY, maxX, maxY;
        startX = startY = minX = minY = maxX = maxY = 50;
        map[startY][startX] = '.';
        
        int dir = 2;

        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == 'F') {     
                startX += dx[dir];
                startY += dy[dir];
                map[startY][startX] = '.';
                
                maxX = Math.max(maxX, startX);
                maxY = Math.max(maxY, startY);
                minX = Math.min(minX, startX);
                minY = Math.min(minY, startY);
            }
            else if(ch[i] == 'L') {
                if(dir == 0)    dir = 3;
                else            dir--;
            }
            else if(ch[i] == 'R') {
                if(dir == 3)    dir = 0;
                else            dir++;
            }
        }

        for(int i = minY ; i <= maxY ; i++) {
            for(int j = minX ; j <= maxX ; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}