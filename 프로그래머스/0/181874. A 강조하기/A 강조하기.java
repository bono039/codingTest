import java.util.*;

class Solution {
    public String solution(String myString) {       
        StringBuilder sb = new StringBuilder();
        
        for(char c : myString.toLowerCase().toCharArray()){
            if(c == 'a')
                sb.append('A');
            else
                sb.append(c);
        }
        
        return sb.toString();
    }
}