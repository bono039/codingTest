import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        Map<Character, Integer> mbti = new HashMap<>();
        mbti.put('R', 0); mbti.put('T', 0);
        mbti.put('C', 0); mbti.put('F', 0);
        mbti.put('J', 0); mbti.put('M', 0);
        mbti.put('A', 0); mbti.put('N', 0);
        
        for(int i = 0 ; i < survey.length ; i++) {            
            if(choices[i] < 4) {
                mbti.put(survey[i].charAt(0), mbti.get(survey[i].charAt(0)) + (4 - choices[i]));
            }
            else if(choices[i] > 4) {
                mbti.put(survey[i].charAt(1), mbti.get(survey[i].charAt(1)) + (choices[i] - 4));
            }
        }

        sb.append((mbti.get('R') >= mbti.get('T')) ? "R" : "T");
        sb.append((mbti.get('C') >= mbti.get('F')) ? "C" : "F");
        sb.append((mbti.get('J') >= mbti.get('M')) ? "J" : "M");
        sb.append((mbti.get('A') >= mbti.get('N')) ? "A" : "N");

        return sb.toString();
    }
}