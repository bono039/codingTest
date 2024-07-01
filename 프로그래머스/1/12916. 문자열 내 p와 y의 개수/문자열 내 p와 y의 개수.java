import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        
        int pCnt = 0;
        int yCnt = 0;
        for(char c : ch) {
            if(c == 'p')         pCnt++;
            else if(c == 'y')    yCnt++;
        }
        
        boolean answer = true;
        if(pCnt != yCnt)
            answer = false;

        return answer;
    }
}