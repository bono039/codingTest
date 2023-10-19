import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 내림차순 정렬
        for(int w : works) pq.add(w);
        
        for(int i = 0 ; i < n ; i++) {
            int max = (int)pq.poll();
            if(max <= 0) break;
            pq.add(max - 1);
        }
        
        // 제곱들의 값 구하기        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}