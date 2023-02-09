import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        // 알파벳 먼저 띄어쓰기로 replaceAll
        my_string = my_string.replaceAll("[^0-9]", " ").trim();
        System.out.print(my_string);
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(my_string.split(" ")));
        
        for(String i : list) {
            if(i.equals("")) {
                continue;
            }
            else {
                answer += Integer.parseInt(i.trim());                
            }
        }
        
        return answer;
    }
}