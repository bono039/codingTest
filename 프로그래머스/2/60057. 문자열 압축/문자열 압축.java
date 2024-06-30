import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int i = 1 ; i <= len/2 ; i++) {
            int cnt = 0;
            String tmp = "";
            String target = s.substring(0, i);
            
            for(int j = 0 ; j <= len ; j += i) {
                String ss = s.substring(j, Math.min(j+i, len));
                
                if(ss.equals(target)) {
                    cnt++;
                }
                else {
                    if(cnt >= 2) {
                        tmp += cnt;
                    }
                    tmp += target;
                    target = ss;
                    cnt = 1;
                }                
            }
            
            if(cnt >= 2) {
                tmp += cnt;
            }
            tmp += target;
            answer = Math.min(answer, tmp.length());
        }
        
        return answer;
    }
}