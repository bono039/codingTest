import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);   

        for(int i = 0 ; i <= citations[citations.length - 1] ; i++) {
            int h = i;
            int cnt = 0;

            for(int c : citations) {
                if(c >= h) cnt++;
            }

            if(cnt >= h && (citations.length - cnt) <= h)
                answer = Math.max(answer, h);
        }            
        
        return answer;
    }
}