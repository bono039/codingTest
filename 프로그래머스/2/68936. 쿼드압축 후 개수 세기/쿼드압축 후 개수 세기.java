import java.util.*;

class Solution {
    static int[][] arr;
    static int len;
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        len = arr.length;
        
        solve(0,0,len);    
        
        int[] answer = new int[2];
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                if(arr[i][j] == 0)      answer[0]++;
                else if(arr[i][j] == 1) answer[1]++;
            }
        }
        return answer;
    }
    
    private static void solve(int x, int y, int size) {
        int zeroCnt = 0;
        int oneCnt = 0;
        
        for(int i = x ; i < x+size ; i++) {
            for(int j = y ; j < y+size ; j++) {
                if(arr[i][j] == 0)      zeroCnt++;
                else if(arr[i][j] == 1) oneCnt++;
            }
        }
        
        if(zeroCnt == 0) {
            for(int i = x ; i < x+size ; i++) {
                for(int j = y ; j < y+size ; j++) {
                    if(i == x && j == y)    continue;
                    
                    arr[i][j] = -1;
                }
            }
            
            return;
        }
        
        if(oneCnt == 0) {
            for(int i = x ; i < x+size ; i++) {
                for(int j = y ; j < y+size ; j++) {
                    if(i == x && j == y)    continue;
                    
                    arr[i][j] = -1;
                }
            } 
            
            return;
        }
        
        solve(x, y, size/2);
        solve(x+size/2, y, size/2);
        solve(x, y+size/2, size/2);
        solve(x+size/2, y+size/2, size/2);
    }
}