import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
          
        List<Integer> answer = new ArrayList<>();
        
        for(int i : arr) {
            if(i % divisor == 0) {
                answer.add(i);
            }
        }
        
        answer.sort(Comparator.naturalOrder());
        
        if(answer.size() == 0) answer.add(-1);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}