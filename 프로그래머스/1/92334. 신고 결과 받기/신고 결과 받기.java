import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, Set<String>> infoMap = new HashMap<>();
                
        for(String r : report) {
            String[] s = r.split(" ");
            
            infoMap.putIfAbsent(s[0], new HashSet<>());
            if(infoMap.get(s[0]).add(s[1]))
                reportCnt.put(s[1], reportCnt.getOrDefault(s[1], 0) + 1);
        }
        
        Set<String> noUsers = new HashSet<>();        
        for(String s : reportCnt.keySet()) {
            if(reportCnt.get(s) >= k) {
                noUsers.add(s);
            }
        }
        
        for(int i = 0 ; i < id_list.length ; i++) {
            String user = id_list[i];
            
            if(infoMap.containsKey(user)) {
                for(String x : infoMap.get(user)) {
                    if(noUsers.contains(x))
                        answer[i]++;
                }
            }
        }
                
        return answer;
    }
}