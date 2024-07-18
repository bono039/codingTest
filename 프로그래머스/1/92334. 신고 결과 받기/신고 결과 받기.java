import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, HashSet<String>> map = new HashMap<>();
                
        for(int i = 0 ; i < id_list.length ; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }
        
        for(String r : report) {
            String[] s = r.split(" ");            
            map.get(s[1]).add(s[0]);
        }

        for(int i = 0 ; i < id_list.length ; i++) {
            HashSet<String> send = map.get(id_list[i]);
            
            if(send.size() >= k) {
                for(String x : send) {
                    answer[idxMap.get(x)]++;
                }
            }
        }
                
        return answer;
    }
}