import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeroCnt = 0;
        
        while(!s.equals("1")) {
            String newStr = s.replaceAll("0", "");
            int len = newStr.length();
            
            zeroCnt += s.length() - len;
            s = Integer.toBinaryString(len);
            cnt++;
        }
        
        return new int[]{cnt, zeroCnt};
    }
}