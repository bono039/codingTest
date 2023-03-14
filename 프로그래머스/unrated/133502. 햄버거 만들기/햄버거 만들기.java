import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        // StringBuilder로 만들고
        // substring해서 1231이면 delete
        for(int i=0 ; i < ingredient.length ; i++) {
            sb.append(ingredient[i]);
            
            int len = sb.length();
            
            if(len > 3 && sb.substring(len - 4, len).equals("1231")) {
                sb.delete(len - 4, len);
                answer++;
            }
        }
        
        return answer;
    }
}