import java.util.*;

class Solution {
    static int[] n1 = {1,2,3,4,5};
    static int[] n2 = {2,1,2,3,2,4,2,5};
    static int[] n3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {    
        int[] scores = new int[3];
            
        for(int i = 0 ; i < answers.length ; i++) {
            if(answers[i] == n1[i%5])  scores[0]++;
            if(answers[i] == n2[i%8])  scores[1]++;
            if(answers[i] == n3[i%10]) scores[2]++;
        }
               
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++) {
            if(scores[i] == max)
                list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}