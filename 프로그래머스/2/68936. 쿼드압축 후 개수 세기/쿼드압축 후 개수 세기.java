import java.util.*;

class Solution {
    static int[][] arr;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        
        divide(0, 0, arr.length);        
        return answer;
    }
    
    private static void divide(int x, int y, int size) {
        if(zip(x, y, size)) {
            if(arr[x][y] == 0)  answer[0]++;
            else                answer[1]++;
            
            return;
        }
        
        divide(x,          y,          size/2);
        divide(x,          y + size/2, size/2);
        divide(x + size/2, y,          size/2);
        divide(x + size/2, y + size/2, size/2);
    }
    
    private static boolean zip(int x, int y, int size) {        
        for(int i = x ; i < x + size ; i++) {
            for(int j = y ; j < y + size ; j++) {
                if(arr[i][j] != arr[x][y])
                    return false;
            }
        }
        
        return true;
    }
}