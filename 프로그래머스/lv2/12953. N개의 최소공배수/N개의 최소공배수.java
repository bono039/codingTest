import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length ; i++) {
            answer = answer * arr[i] / getGCD(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 유클리드
    public int getGCD(int a, int b) {
        if(b == 0) return a;
        else       return getGCD(b, a % b);
    }
}