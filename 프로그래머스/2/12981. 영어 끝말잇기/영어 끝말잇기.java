import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
                        
        Set<String> set = new HashSet<>();  
        set.add(words[0]);
        
        for(int i = 1 ; i < words.length ; i++) {
            if(!set.contains(words[i]) && words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0)) {
                set.add(words[i]);
            }
            else {
                return new int[]{i%n +1, i/n +1};
            }
        }

        return answer;
    }
}