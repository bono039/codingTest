import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = new String[my_string.length()];
        
        my_string = my_string.toLowerCase();
        
        for(int i=0 ; i < my_string.length() ; i++) {
            arr[i] = String.valueOf(my_string.charAt(i));
        }
        
        Arrays.sort(arr);
        
        for(String s : arr) {
            answer += s;
        }
        
        
        return answer;
    }
}