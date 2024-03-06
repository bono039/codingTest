import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        Set<String> set = new TreeSet<>();
        
        for(int i = 0 ; i < my_string.length() ; i++) {
            set.add(my_string.substring(i));
        }        
        
        String[] answer = new String[set.size()];
        int idx = 0;
        for(String s : set) {
            answer[idx++] = s;
        }       
        
        return answer;
    }
}