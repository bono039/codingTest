import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];  // 가장 먼저 탈락하는 삶 번호, 몇 번째 차례에 탈락
        List<String> list = new ArrayList<>();
      
        for(int i = 0 ; i < words.length ; i++) {
            if(list.contains(words[i])) {
                answer[0] = i % n + 1; // 사람
                answer[1] = i / n + 1; // 차례
                break;
            }
        
            list.add(words[i]);
        
            if(i > 0 && words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {            
                answer[0] = i % n + 1;  // 사람
                answer[1] = i / n + 1;  // 차례
                break;
            }
        }
        return answer;
    }
}