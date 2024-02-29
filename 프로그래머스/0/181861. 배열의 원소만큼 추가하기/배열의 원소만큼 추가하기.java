import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr) {
            int cnt = num;
            while(cnt -- > 0)
                list.add(num);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}