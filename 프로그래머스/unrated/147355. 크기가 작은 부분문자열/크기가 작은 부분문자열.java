import java.util.*;

class Solution {
    public int solution(String t, String p) {
        
        int len = p.length();
        int answer = 0;
        
        for(int i=0 ; i < t.length() - len +1 ; i++) {
            if(Long.parseLong(t.substring(i, i+len)) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}