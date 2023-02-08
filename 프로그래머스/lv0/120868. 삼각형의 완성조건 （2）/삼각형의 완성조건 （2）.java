import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        int n = sides[1];
        
        // 가장 긴 변의 길이 (max) < 다른 두 변의 길이의 합
        // 나머지 한 변이 될 수 있는 정수의 개수
        
        // 1) 가장 긴 변이 n인 경우
        for(int i=1; i <= n ; i++) {
            if((i + sides[0]) > n) {
                answer++;
            }
        }
        
        // 2) 나머지 한 변이 가장 긴 경우
        for(int i=n ; i < (sides[0] + sides[1]) ; i++) {
            answer++;
        }
        
        
        return answer-1;
    }
}