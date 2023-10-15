import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {        
        List<Integer> list = new ArrayList<>();
        
        int outIdx = 0;
        for(int i = 0 ; i < commands.length ; i++) {
            int[] tmpArr = new int[commands[i][1] - commands[i][0] + 1];
            int idx = 0;
            for(int j = commands[i][0] - 1 ; j < commands[i][1] ; j++) {
                tmpArr[idx++] = array[j];
            }
            Arrays.sort(tmpArr);
            list.add(tmpArr[commands[i][2] - 1]);
        }
    
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}