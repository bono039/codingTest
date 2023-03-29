import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];  // 최고 순위, 최저 순위
        int cnt = 0;
        
        for(int i=0 ; i < lottos.length ; i++) {
            for(int j=0 ; j < win_nums.length ; j++) {
                if(lottos[i] == win_nums[j]) {
                    cnt++;
                }
            }
        }
        
        int zeroCnt = 0;
        for(int i: lottos) {
            if(i == 0) {
                zeroCnt++;
            }
        }
        
        int max = cnt + zeroCnt;
        int min = cnt;
        
        switch(max) {
            case 2 : answer[0] = 5;
                     break;
            case 3 : answer[0] = 4;
                     break;
            case 4 : answer[0] = 3;
                     break;
            case 5 : answer[0] = 2;
                     break;
            case 6 : answer[0] = 1;
                     break;
                
            default: answer[0] = 6;
                     break;
        }
        
        switch(min) {
            case 2 : answer[1] = 5;
                     break;
            case 3 : answer[1] = 4;
                     break;
            case 4 : answer[1] = 3;
                     break;
            case 5 : answer[1] = 2;
                     break;
            case 6 : answer[1] = 1;
                     break;
                
            default: answer[1] = 6;
                     break;
        }
        
        
        return answer;
    }
}