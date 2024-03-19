import java.util.*;

class Solution {
    static int[] cards;
    static PriorityQueue<Integer> pq;
    static boolean[] visited;
    static int answer = 0;  // 얻을 수 있는 최고 점수
    
    public int solution(int[] cards) {
        this.cards = cards;
        
        pq = new PriorityQueue<>(Collections.reverseOrder());    // 리스트 크기 기준 정렬
        visited = new boolean[cards.length];
        
        for(int i = 0 ; i < cards.length ; i++) {
            if(!visited[i])
                dfs(i, 0);
        }
        
        if(pq.size() != 1)
            answer = pq.poll() * pq.poll();
        
        return answer;
    }
    
    private static void dfs(int idx, int depth) {
        if(visited[idx]) {
            pq.add(depth);
            return;
        }
        
        visited[idx] = true;
        dfs(cards[idx] - 1, depth + 1);
    }
}