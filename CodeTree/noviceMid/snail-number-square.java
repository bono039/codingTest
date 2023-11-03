import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,0,-1};   // 동남서북
    static int[] dy = {1,0,-1,0};

    static int N, M;
    static int[][] map; // 정답 저장 겸 방문 기록 배열

    static int[] pos = new int[] {0,0}; // 현재 위치 (x, y). 시작점은 (0,0)
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        map[0][0] = 1;  // 시작점은 1로 설정

        // 달팽이 모양으로 채우기
        for(int i = 2 ; i <= N * M ; i++) {
            int nx = pos[0] + dx[dir];
            int ny = pos[1] + dy[dir];

            // 격자를 벗어나거나, 이미 방문한 칸이라면 방향 전환
            if(!inRange(nx, ny) || (map[nx][ny] != 0)) {
                dir = (dir + 1) % 4;
            }

            // 이동하고 칸에 값 채워넣기
            pos[0] += dx[dir];
            pos[1] += dy[dir];
            map[pos[0]][pos[1]] = i;
        }

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for(int[] i : map) {
            for(int j : i) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // 범위 확인용 메소드
    private static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}
