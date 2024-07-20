import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        
        for(int[] c : commands) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = c[0] - 1 ; i <= c[1] - 1 ; i++) {
                tmp.add(array[i]);
            }
            Collections.sort(tmp);
            list.add(tmp.get(c[2] - 1));
        }
            
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}