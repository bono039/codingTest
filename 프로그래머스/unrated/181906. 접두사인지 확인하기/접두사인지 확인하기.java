import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        
        boolean isPrefix = false;
        
        for(int i = 0 ; i < my_string.length() ; i++) {
            if(my_string.substring(0, i).equals(is_prefix)) {
                isPrefix = true;
                break;
            }
        }
        
        return isPrefix ? 1 : 0;
    }
}