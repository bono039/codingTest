import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<String>();
        set.add(words[0]);
        
        String prev = "";

        for(int i = 1; i < words.length; i ++){
            prev = words[i - 1];
            
            if(set.contains(words[i]) || prev.charAt(prev.length() - 1) != words[i].charAt(0)){
                answer[0] = i % n + 1;	// 사람
                answer[1] = i / n + 1;	// 차례
                break;
            }
            set.add(words[i]);
        }
        return answer;
    }
}