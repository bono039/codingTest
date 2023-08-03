import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};    // 동남서북
    static int[] dy = {1, 0, -1, 0};
    
    static int N, apple, L;
    static int[][] board;
    static List<int[]> snake = new ArrayList<>();
    static HashMap<Integer, String> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        apple = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        while(apple --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            
            board[a][b] = 1;
        }
        
        
        L = Integer.parseInt(br.readLine());
        while(L --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();
            
            map.put(X, cmd);
        }
        
        bfs();
    }
    
    private static void bfs() {
        int x = 0;
        int y = 0;
        
        int time = 0;
        int d = 0;
        snake.add(new int[] {0, 0});
        
        while(true) {
            time++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isFinish(nx,ny)) {
                break;
            }

            if(board[nx][ny] == 1) {
                board[nx][ny] = 0;
                snake.add(new int[] {nx, ny});
            }
            else {
                snake.add(new int[] {nx, ny});
                snake.remove(0);
            }

            if(map.containsKey(time)) {
                if(map.get(time).equals("D")) {
                    d += 1;
                    if(d == 4) d = 0;
                }
                else {
                    d -= 1;
                    if(d == -1) d = 3;
                }
            }

            x = nx;
            y = ny;
        }
        
        System.out.println(time);
    }
    
    private static boolean isFinish(int nx, int ny) {
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
            return true;
        }
        
        for(int i = 0 ; i < snake.size() ; i++) {
            int[] tmp = snake.get(i);
            
            if(nx == tmp[0] && ny == tmp[1]) {
                return true;
            }
        }
        return false;
    }  
}