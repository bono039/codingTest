import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {        
        Arrays.sort(indices);
        StringBuilder sb = new StringBuilder(my_string);
        
        for(int i = indices.length - 1 ; i >= 0 ; i--) {
            sb.deleteCharAt(indices[i]);
        }
        
        return sb.toString();
    }
}