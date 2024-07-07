import java.util.*;

class Solution {
    static int[][] arr;
    static int len;
    static int zeroCnt = 0, oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        len = arr.length;
        
        solve(0, 0, len);
        return new int[]{zeroCnt, oneCnt};
    }
    
    private static void solve(int x, int y, int size) {
        if(check(x, y, size)) {
            if(arr[x][y] == 0)      zeroCnt++;
            else if(arr[x][y] == 1) oneCnt++;
            
            return;
        }
        
        int newSize = size/2;
        
        solve(x,         y,         newSize);
        solve(x+newSize, y,         newSize);
        solve(x,         y+newSize, newSize);
        solve(x+newSize, y+newSize, newSize);
    }
    
    private static boolean check(int x, int y, int size) {
        int v = arr[x][y];
        
        for(int i = x ; i < x+size ; i++) {
            for(int j = y ; j < y+size ; j++) {
                if(arr[i][j] != v)
                    return false;
            }
        }
        
        return true;
    }
}