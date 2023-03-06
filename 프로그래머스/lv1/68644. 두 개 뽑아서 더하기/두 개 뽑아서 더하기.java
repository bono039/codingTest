import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        int len = numbers.length;
        Arrays.sort(numbers);

        Set<Integer> set = new HashSet<>();
        
        for(int i=0 ; i < len ; i++) {
            for(int j=i+1; j < len ; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        return set.stream().sorted().mapToInt(i->i).toArray();
    }
}