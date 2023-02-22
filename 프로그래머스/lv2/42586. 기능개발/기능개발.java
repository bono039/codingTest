import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();    
        
        for (int i = 0; i < progresses.length; i++) {
            int used =  (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                used++;
            }
            
            list.add(used);
            System.out.println(used);
        }
        
        int p = list.get(0);
        int x = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) > p) {
                answer.add(x);
                p = list.get(j);
                x = 1;
            } else {
                x++;
            }
        }
        answer.add(x);
        
        // List -> int[]
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}