import java.util.*;

class Solution {
    static int m,n;
    static String[] board;
    static char[][] grid;
    
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        this.board = board;
        
        grid = new char[m][n];
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length() ; j++) {
                grid[i][j] = board[i].charAt(j);
            }
        }
        
        while(true) {
            // 1. 정사각형인 부분 찾기
            Set<int[]> set = findSquares();            
            if(set.isEmpty())   break;
            
            // 2. 정사각형인 부분 제거하기 (.으로 변경)
            for(int[] p : set) {
                grid[p[0]][p[1]] = '.';
            }
            
            // 3. 끌어내리기
            dropBlocks();
            
            // System.out.println("======== 끌어내린 후 ========");
            // for(char[] ch : grid) {
            //     for(char c : ch)
            //         System.out.print(c + " ");
            //     System.out.println();
            // }
        }

        int answer = 0;
        for(char[] ch : grid) {
            for(char c : ch) {
                if(c == '.')
                    answer++;
            }
        }
        
        return answer;
    }

    // 정사각형에 속하는 좌표 저장하는 집합 만드는 메서드
    private static Set<int[]> findSquares() {
        Set<int[]> tmpSet = new HashSet<>();    // 중복 좌표 제거 위해 Set으로 저장
        
        for(int i = 0 ; i < m - 1 ; i++) { 
            for(int j = 0 ; j < n - 1 ; j++) {
                if(grid[i][j] != '.' && isSquare(i, j)) {
                    tmpSet.add(new int[]{i,j});
                    tmpSet.add(new int[]{i+1,j});
                    tmpSet.add(new int[]{i,j+1});
                    tmpSet.add(new int[]{i+1,j+1});
                }
            }
        }  
        
        return tmpSet;
    }

    // 중력 적용 메서드
    private static void dropBlocks() {
        char[][] tmpGrid = new char[m][n];    // 2차원 임시 배열 생성
        boolean[][] visited = new boolean[m][n];

        // 2차원 임시배열 채워넣기
        for(int col = 0 ; col < n ; col++) {
            int tmpRow = m - 1;

            for(int row = m - 1 ; row >= 0 ; row--) {
                if(grid[row][col] != '.') {
                    visited[tmpRow][col] = true;
                    tmpGrid[tmpRow][col] = grid[row][col];
                    tmpRow--;
                }                    
            }
        }

        // 임시 배열의 값을 원본 배열로 복사하는 과정
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(visited[i][j])   grid[i][j] = tmpGrid[i][j];
                else grid[i][j] = '.';
            }
        }         
    }

    // 2*2 정사각형 이루는지 판별하는 메서드
    private static boolean isSquare(int x, int y) {  
        return (grid[x][y] == grid[x+1][y] && grid[x][y] == grid[x][y+1] && grid[x][y] == grid[x+1][y+1]);
    }
}
