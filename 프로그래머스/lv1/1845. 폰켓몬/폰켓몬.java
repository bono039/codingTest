import java.util.*;

class Solution {
    public int solution(int[] nums) {

        int answer = 0;
        int max = nums.length / 2;      
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        
        if(hm.size() > max) {
            answer = max;
        } else {
            answer = hm.size();
        }
        
        
        return answer;
    }
}