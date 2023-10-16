import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] scores = new int[3];
        
        for(int i = 0 ; i < answers.length ; i++) {
            if(answers[i] == p1[i % p1.length]) scores[0]++;
            if(answers[i] == p2[i % p2.length]) scores[1]++;
            if(answers[i] == p3[i % p3.length]) scores[2]++;
        }
        
        // 최대 점수 구하기
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // 최대 점수 가진 수포자 리스트 생성
        List<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i < scores.length ; i++) {
            if(max == scores[i])
                answer.add(i + 1);
        }
        
        // 최대 점수 가진 수포자 리스트 -> 배열로 변경해 출력하기
        int[] ans = new int[answer.size()];
        for(int i = 0 ; i < answer.size() ; i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}