import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int map[][];
    public static int answer;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    for(int j = 1 ; j <= N ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		answer = 0;
		DFS(1, 2, 0);
		
		System.out.println(answer);
		br.close();
	}
	

	public static void DFS(int x, int y, int direction) {
	    if(x == N && y == N) {
	        answer++;
	        return;
	    }
	    
        if(direction == 0) {
            if(y + 1 <= N && map[x][y + 1] == 0)
                DFS(x, y + 1, 0);
        }
        else if(direction == 1) {
            if(x + 1 <= N && map[x + 1][y] == 0)
                DFS(x + 1, y , 1);
        }
        else if(direction == 2) {
            if(y + 1 <= N && map[x][y + 1] == 0)
                DFS(x, y + 1, 0);
            if(x + 1 <= N && map[x + 1][y] == 0) 
                DFS(x + 1, y , 1);
        }
        
        if(y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
	}
}