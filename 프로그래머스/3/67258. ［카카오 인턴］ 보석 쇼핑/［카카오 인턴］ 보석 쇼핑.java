import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String g : gems) {
            set1.add(g);
        }
        
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        
        int[] answer = new int[2];
                
        while(left <= right && right < gems.length) {            
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            set2.add(gems[right]);
            
            while(map.get(gems[left]) > 1) {
                map.replace(gems[left], map.get(gems[left]) -1);
                left++;
            }
            
            if(right - left < len && set1.size() == set2.size()) {
                answer[0] = left+1;
                answer[1] = right+1;
                len = right - left;
            }
            right++;
        }
                
        return answer;
    }
}