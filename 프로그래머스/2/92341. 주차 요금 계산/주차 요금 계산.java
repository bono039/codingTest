import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, String> map = new HashMap<>();  // 차 번호, 시간
        Map<String, Integer> feeMap = new TreeMap<>();  // 차 번호, 요금 (차량번호 기준 오름차순 정렬)
        
        for(int i = 0 ; i < records.length ; i++) {
            feeMap.put(records[i].split(" ")[1], 0);
        }
        
        // IN-OUT 기록 둘 다 있는 경우
        for(int i = 0 ; i < records.length ; i++) {
            String[] infos = records[i].split(" ");
            
            if(map.containsKey(infos[1])) {
                String[] inTime = map.remove(infos[1]).split(":");
                String[] outTime = infos[0].split(":");
                
                int HH = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int MM = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                
                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60 * HH + MM);
            }
            else {
                map.put(infos[1], infos[0]);    // 차 번호, 시간
            }
        }
        
        // IN 기록만 있는 경우
        for(String key : map.keySet()) {
            String[] inTime = map.get(key).split(":");
            
            int HH = 23 - Integer.parseInt(inTime[0]);
            int MM = 59 - Integer.parseInt(inTime[1]);
            
            feeMap.replace(key, feeMap.get(key) + 60 * HH + MM);
        }
        
        List<Map.Entry<String,Integer>> list = new ArrayList(feeMap.entrySet());    // 차량번호 기준 정렬       
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            if(list.get(i).getValue() > fees[0]) {
                answer[i] = fees[1] + (int)Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }
            else {
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
}