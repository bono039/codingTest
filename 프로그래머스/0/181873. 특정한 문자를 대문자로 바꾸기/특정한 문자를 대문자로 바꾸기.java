import java.util.*;

class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < my_string.length() ; i++) {
            String tmp = my_string.substring(i, i+1);
            if(tmp.equals(alp))
                sb.append(tmp.toUpperCase());
            else
                sb.append(tmp);
        }
        
        return sb.toString();
    }
}