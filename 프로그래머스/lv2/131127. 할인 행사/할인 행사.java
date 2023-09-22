import java.util.*;

class Solution {
    String[] want;
    int[] number;
    String[] discount;
    
    public int solution(String[] want, int[] number, String[] discount) {
        this.want = want;
        this.number = number;
        this.discount = discount;
        
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            boolean isPossible = true;
            Map<String, Integer> tmpMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                tmpMap.put(discount[j], tmpMap.getOrDefault(discount[j], 0) + 1);
            }
            
            for (int k = 0; k < want.length; k++) {
                if (tmpMap.get(want[k]) != map.get(want[k])) {
                    isPossible = false;
                    break;
                }
            }
            
            answer += isPossible ? 1 : 0;
        }
        return answer;
    }
}
