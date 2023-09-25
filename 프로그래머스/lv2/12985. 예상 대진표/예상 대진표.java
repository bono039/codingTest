import java.util.*;

// a는 b를 몇 번째 라운드에서 만날까?
class Solution {
    public int solution(int n, int a, int b) {  // 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B
        
        int cnt = 0;
        while(true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            cnt++;
            
            if(a == b) break;
        }

        return cnt;
    }
}