import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        String odd = ""; // 홀
        String even = "";   // 짝
        
        for(int i : num_list) {
            if(i % 2 == 0) even += Integer.toString(i);
            else odd += Integer.toString(i);
        }
        
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
}