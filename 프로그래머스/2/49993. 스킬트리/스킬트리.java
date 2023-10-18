import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String st : skill_trees) {
            boolean isOK = true;
            int skillIdx = 0;
            
            // 각 스킬 트리의 스킬 순서 확인
            for(char current : st.toCharArray()) {
                int order = skill.indexOf(current);
                
                if(order == -1) continue;   // 해당 스킬이 아니면 넘어감
                
                if(order == skillIdx) { // 현재 스킬이 순서에 맞는 경우
                    skillIdx++;
                }
                else {
                    isOK = false;
                    break;
                }
            }
                        
            if(isOK)    answer++;
        }
        
        return answer;
    }
}