import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();    // 귤 종류, 갯수
        
        // 귤 종류와 갯수 저장하기
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // map, 갯수가 많은 순 (=내림차순) 정렬
        List<Integer> vList = new ArrayList<>(map.values()); 
        vList.sort((o1, o2) -> o2 - o1);
        
        // map 돌면서 가능한 경우의 최솟값 찾기
        int sum = 0;    // 고른 귤 개수
        int min = 0;    // 최솟값
        
        for(int v : vList) {
            if(sum + v >= k) {
                min++;
                break;
            }
            else {
                sum += v;
                min++;
            }
        }
        
        return min;
    }
}