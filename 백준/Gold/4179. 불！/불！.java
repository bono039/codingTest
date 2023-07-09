import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    static int R, C, res;
    static char[][] map;
    static Queue<State> fire, jh;
    
    static class State {
        int x, y, d;
        
        public State(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        
        jh = new LinkedList<>();
        fire = new LinkedList<>();
        
        // 입력받아 배열 초기화
        for(int i = 0 ; i < R ; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0 ; j < C ; j++) {
                // 불 위치
                if(map[i][j] == 'F') {
                    fire.add(new State(i, j, 0));
                }
                // 지훈 위치
                if(map[i][j] == 'J') {
                    jh.add(new State(i, j, 0));
                }
            }
        }       
        
        System.out.println(bfs() ? res : "IMPOSSIBLE");
    }
    
    private static boolean bfs() {
        while(!jh.isEmpty()) {
            // 불이 먼저 퍼짐
            int size = fire.size();
            for(int i = 0 ; i < size ; i++) {
                State now = fire.poll();
                
                for(int d = 0 ; d < 4 ; d++) {
                    int xx = now.x + dx[d];
                    int yy = now.y + dy[d];
                    
                    if(xx < 0 || xx >= R || yy < 0 || yy >= C) continue;
                    if(map[xx][yy] == '#' || map[xx][yy] == 'F')    continue;
                    
                    map[xx][yy] = 'F';
                    fire.add(new State(xx, yy, now.d + 1));                    
                }
            }
            
            
            // 지훈이가 불을 피해 이동
            size = jh.size();
            for(int i = 0 ; i < size ; i++) {
                State now = jh.poll();
                
                for(int d = 0 ; d < 4 ; d++) {
                    int xx = now.x + dx[d];
                    int yy = now.y + dy[d];
                    
                    // 범위 벗어남 = 탈출
                    if(xx < 0 || yy < 0 || xx >= R || yy >= C) {
                        res = now.d + 1;
                        return true;
                    }
                    
                    if(map[xx][yy] == '#' || map[xx][yy] == 'F' || map[xx][yy] == 'J')  continue;
                    
                    map[xx][yy] = 'J';
                    jh.add(new State(xx, yy, now.d + 1));
                }
            }
        }
        return false;
    }
}
