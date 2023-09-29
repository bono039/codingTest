import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};    // 상하좌우
    static int[] dy = {1, -1, 0, 0};
    
    static boolean[][][] visited; // 방문 여부를 저장하는 배열, 3차원 배열로 각 위치와 이동 방향을 저장
    static int[] dir = {0, 0}; // 초기 위치는 (0, 0)
    
    public int solution(String dirs) {
        visited = new boolean[11][11][4]; // 11x11 격자, 4가지 방향
        
        int cnt = 0; // 움직인 횟수를 카운트
        
        for(char ch : dirs.toCharArray()) {
            int dirIdx = getDirectionIndex(ch);
            
            if (dirIdx == -1) {
                continue; // 유효하지 않은 방향 문자라면 무시
            }
            
            int nx = dir[0] + dx[dirIdx];
            int ny = dir[1] + dy[dirIdx];
            
            if (inRange(nx, ny)) {
                // 이미 방문한 경로인지 확인
                if (!visited[dir[0] + 5][dir[1] + 5][dirIdx]) {
                    visited[dir[0] + 5][dir[1] + 5][dirIdx] = true;
                    visited[nx + 5][ny + 5][reverseDirection(dirIdx)] = true;
                    cnt++;
                }
                dir[0] = nx;
                dir[1] = ny;
            }
        }
        
        return cnt;
    }
    
    static boolean inRange(int x, int y) {
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }
    
    static int getDirectionIndex(char ch) {
        switch (ch) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
            default:
                return -1; // 유효하지 않은 방향 문자
        }
    }
    
    static int reverseDirection(int dirIdx) {
        return (dirIdx + 1) % 2 == 0 ? dirIdx - 1 : dirIdx + 1;
    }
}
