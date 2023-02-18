import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] str = Long.toString(n).split("");
        
        Arrays.sort(str, Collections.reverseOrder());
        
        String hi = "";
        
        for(String s : str) {
            hi += s;
        }
        
        answer = Long.parseLong(hi);
        
        return answer;
    }
}