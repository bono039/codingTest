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
        
        int answer = 0;
        while(true) {
            // 1. 정사각형인 부분 찾기
            Set<int[]> set = findSquares();
            
            if(set.isEmpty())   break;
            
            // 2. 정사각형인 부분 제거하기 (.으로 변경하고 cnt 증가)
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
        
        for(char[] ch : grid) {
            for(char c : ch) {
                if(c == '.')
                    answer++;
            }
        }
        
        return answer;
    }
    
    private static Set<int[]> findSquares() {
        Set<int[]> tmpSet = new HashSet<>();
        
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
    
    private static void dropBlocks() {
        char[][] tmpGrid = new char[m][n];
        boolean[][] visited = new boolean[m][n];

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

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(visited[i][j])   grid[i][j] = tmpGrid[i][j];
                else grid[i][j] = '.';
            }
        }         
    }
    
    private static boolean isSquare(int x, int y) {  
        return (grid[x][y] == grid[x+1][y] && grid[x][y] == grid[x][y+1] && grid[x][y] == grid[x+1][y+1]);
    }
}