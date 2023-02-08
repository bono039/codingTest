import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(my_string.split("")));
        
        String s1 = list.get(num1);
        String s2 = list.get(num2);
        
        list.set(num1, s2);
        list.set(num2, s1);
        
        String answer = String.join("", list);
        
        return answer;
    }
}