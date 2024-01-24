import java.util.*;

class Solution {
    static int n;
    static int answer = 0;
    static int[] arr;
    
    public int solution(int n) {
        this.n = n;
        arr = new int[n];
        
        nQueen(0);        
        return answer;
    }
    
    private static void nQueen(int row) {
        if (row == n) {
            answer++;
            return;
        }
                
        for (int i = 0; i < n; i++) {
            arr[row] = i;   // 퀸 두기
            
            if(isPossible(row)) {
                nQueen(row + 1);
            }
        }
    }
    
    private static boolean isPossible(int col) {
        for(int i = 0 ; i < col ; i++) {
            if(arr[col] == arr[i])
                return false;
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        
        return true;
    }
}
