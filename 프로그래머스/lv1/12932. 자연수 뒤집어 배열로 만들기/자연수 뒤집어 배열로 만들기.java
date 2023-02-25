import java.util.*;

class Solution {
    public int[] solution(long n) {
        // long -> String[]으로 변환
        String[] str = Long.toString(n).split("");
        
        int[] answer = new int[str.length];
        
        for(int i=0 ; i < str.length ; i++) {
            answer[str.length - 1 - i] = Integer.parseInt(str[i]);
        }
                
        
        return answer;
    }
}