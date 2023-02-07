import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        List<String> list = new ArrayList<>();
        String[] s = my_string.split("");
        
        for(int i=0 ; i < my_string.length() ; i++) {
                if(s[i].equals("0") || 
                   s[i].equals("1") || 
                   s[i].equals("2") || 
                   s[i].equals("3") || 
                   s[i].equals("4") || 
                   s[i].equals("5") || 
                   s[i].equals("6") || 
                   s[i].equals("7") || 
                   s[i].equals("8") || 
                   s[i].equals("9")) {
                    list.add(s[i]);
                }
        }        
            
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i=0 ; i < list.size() ; i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}