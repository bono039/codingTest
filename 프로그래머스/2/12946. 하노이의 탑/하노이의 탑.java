import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        Hanoi(n, 1,2,3);
        
        int[][] answer = new int[list.size()][2];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private static void Hanoi(int n, int from, int via, int to) {
         if(n == 1) {
             list.add(new int[]{from, to});
             return;
         }
        
         Hanoi(n-1, from, to, via);     // 1->2
         list.add(new int[]{from, to}); // 1->3
         Hanoi(n-1, via, from, to);     // 2->3
    }
}