import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");
        int cnt = 0;
        
        for(String ss : str) {
            cnt = ss.contains(" ") ? 0 : (cnt+1);
            sb.append((cnt % 2 == 0) ? ss.toLowerCase() : ss.toUpperCase());
        }
        
        return sb.toString();
    }
}