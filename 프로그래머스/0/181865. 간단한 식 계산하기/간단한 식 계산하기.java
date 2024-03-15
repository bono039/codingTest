import java.util.*;

class Solution {
    public int solution(String binomial) {
        int answer = 0;
        int idx = 0;
        int num = 0;
        
        for(int i = 0 ; i < binomial.length() ; i++) {
            String tmp = binomial.substring(i, i+1);
            if(tmp.equals("+")) {
                num = 0;
                idx = i;
                break;
            }
            else if(tmp.equals("-")) {
                num = 1;
                idx = i;
                break;
            }
            else if(tmp.equals("*")) {
                num = 2;
                idx = i;
                break;
            }
        }
        
        int n1 = Integer.parseInt(binomial.substring(0, idx).trim());
        int n2 = Integer.parseInt(binomial.substring(idx + 1).trim());
        
        if(num == 0) {  // +
            answer = n1 + n2;
        }
        else if(num == 1) { // -
            answer = n1 - n2;
        }
        else if(num == 2) { // *
            answer = n1 * n2;
        }
        
        return answer;
    }
}