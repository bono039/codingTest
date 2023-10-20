import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        String tmp = "";
        
        for(int i = 0 ; i < myString.length() ; i++) {
            if(myString.charAt(i) == 'A') tmp += "B";
            else tmp += "A";
        }
        
        return tmp.contains(pat) ? 1 : 0;
    }
}