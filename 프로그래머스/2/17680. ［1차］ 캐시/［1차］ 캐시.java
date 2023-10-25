import java.util.*;

class Solution {    
    public int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0)  return 5 * cities.length;        
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i = 0 ; i < cities.length ; i++) {
            String city = cities[i].toLowerCase();
            
            // [cache hit]
            if(cache.remove(city)) {    // 기존 페이지 지우고,
                cache.addFirst(city);   // 이미 캐시에 있던 페이지 맨 앞으로 가져옴.
                answer += 1;
            }
            else {  // [cache miss]
               int nowSize = cache.size();
                
                if(nowSize == cacheSize) {  // 캐시가 가득찬 경우, 맨 뒤 페이지 삭제
                    cache.pollLast();   // = remove(0)
                }
                
                cache.addFirst(city);   // 맨 앞에 새 페이지 삽입
                answer += 5;
            }
        }
        
        return answer;
    }
}