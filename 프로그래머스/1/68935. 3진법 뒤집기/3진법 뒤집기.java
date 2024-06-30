import java.util.*;

class Solution {
    public int solution(int n) {
        
        String three = Integer.toString(n, 3);
        
        StringBuilder sb = new StringBuilder(three);
        String tmp = sb.reverse().toString();
        
        return Integer.parseInt(tmp, 3);
    }
}