import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>(); // 사전
        for(int i = 1 ; i <= 26 ; i++) {
            map.put(String.valueOf((char)('A' + i - 1)), i);
        }

        int idx = 0;
        
        while(idx < msg.length()) {
            String str = "";
            
            while(idx < msg.length()) {
                if(!map.containsKey(str + msg.charAt(idx))) {
                    break;
                }
                else {
                    str += msg.charAt(idx);
                }
                
                idx++;
            }
            
            list.add(map.get(str));
            
            if(idx < msg.length()) {
                map.put(str + msg.charAt(idx), map.size() + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++)
            answer[i] = list.get(i);
        return answer;
    }
}