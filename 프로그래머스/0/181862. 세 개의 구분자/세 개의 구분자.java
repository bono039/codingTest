import java.util.*;

class Solution {
    public List<String> solution(String myStr) {
        List<String> answer = new ArrayList<>();
        
        myStr = myStr.replaceAll("a", " ")
                        .replaceAll("b", " ")
                        .replaceAll("c", " ")
                        .replaceAll("  ", " ").trim();
                
        String[] list = myStr.split(" ");
        for(String s : list) {
            if(!s.equals(""))
                answer.add(s);
        }
        
        if(answer.size() == 0) answer.add("EMPTY");
        return answer;
    }
}