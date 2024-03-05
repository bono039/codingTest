import java.util.*;

class Solution {
    public int[] solution(String myString) {
        
        String[] str = myString.split("x");
               
        int[] answer = new int[str.length];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = str[i].length();
        }
        
        if(myString.charAt(myString.length() - 1) == 'x') {
            int[] tmp = new int[answer.length + 1];
            for(int i = 0 ; i < answer.length ; i++)
                tmp[i] = answer[i];
            tmp[answer.length] = 0;
            return tmp;
        }
        
        return answer;
    }
}