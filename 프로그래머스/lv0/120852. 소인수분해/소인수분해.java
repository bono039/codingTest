import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int k = 2;
        
        while(n != 1) {
            if(n % k == 0) {
                list.add(k);
                n /= k;
            } else {
                k++;
            }
        }
        
        answer = list.stream().distinct().mapToInt(Integer::intValue).toArray();
        
        
        return answer;
    }
}