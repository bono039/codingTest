import java.util.*;

class Solution {
    public int[] solution(long n) {        
        String str = Long.toString(n);
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        
        int[] answer = new int[str.length()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = str.charAt(i) - '0';
        }
        return answer;
    }
}