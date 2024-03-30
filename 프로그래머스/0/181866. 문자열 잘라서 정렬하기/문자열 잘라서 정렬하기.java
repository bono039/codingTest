import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        Arrays.sort(answer);
        
        List<String> list = new ArrayList<>();
        for(String s : answer) {
            if(s.length() != 0)
                list.add(s);
        }
        
        return list.toArray(new String[0]);
    }
}