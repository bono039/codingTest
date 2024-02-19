import java.util.*;

class Solution {
    static List<String> result = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 1. 각 주문 정렬
        for(int i = 0 ; i < orders.length ; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            
            orders[i] = String.valueOf(ch); // 정렬 결과 저장
        }
        
        // 2. 각 주문을 기준으로 courseLen만큼의 조합 만들기
        for (int courseLen : course) {
            for(String order : orders)
                comb(order, courseLen, "");
            
            // 3. 가장 많은 조합을 answer에 저장
            if(!map.isEmpty()) {
                List<Integer> cntList = new ArrayList<>(map.values());
                int max = Collections.max(cntList); // 가장 많이 주문된 횟수
                
                if(max > 1) // 최소 2번 이상 주문된 조합
                    for(String key : map.keySet())
                        if(map.get(key) == max)
                            result.add(key);
                
                map.clear();
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    private static void comb(String order, int cnt, String tmp) {
        if (cnt == 0) {
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            return;
        }
        
        // 0부터 len까지의 조합
        for (int i = 0; i < order.length(); i++) {
            comb(order.substring(i + 1), cnt - 1, tmp + order.charAt(i));
        }
    }
}
