import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < want.length ; i++) {
            map.put(want[i], number[i]);
        }        
        
        int answer = 0;
        
        for(int i = 0 ; i <= discount.length - 10 ; i++) {
            Map<String, Integer> tmpMap = new HashMap<>();
            
            for(int j = i ; j < i + 10 && j < discount.length ; j++) {
                tmpMap.put(discount[j], tmpMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean b = true;
            for(String w : want) {
                if(map.get(w) > tmpMap.getOrDefault(w, 0)) {
                    b = false;
                    break;
                }
            }
            
            if(b)   answer++;
        }      
        
        return answer;
    }
}