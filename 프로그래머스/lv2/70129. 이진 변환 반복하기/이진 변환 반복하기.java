import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0;
        int convertCnt = 0;
        
        while(!s.equals("1")) {
            String newS = s.replaceAll("0", "");
            int len = newS.length();
            
            cnt += s.length() - len;
            s = Integer.toBinaryString(len);
            convertCnt++;
        }
        answer[0] = convertCnt;
        answer[1] = cnt;

        return answer;
    }
}