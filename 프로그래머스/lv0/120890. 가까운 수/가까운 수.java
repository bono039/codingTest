import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
               
        Arrays.sort(array);
        int diff = 100;
        
        for(int num : array) {
            
            if(Math.abs(n - num) == 0) {
                answer = num;
            }
            
            if(Math.abs(n - num) < diff) {
                diff = Math.abs(n - num);
                answer = num;
            }
        }
        
        return answer;
    }
}