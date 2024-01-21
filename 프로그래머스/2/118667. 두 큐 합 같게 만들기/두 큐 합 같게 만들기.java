import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        
        for(int i = 0 ; i < queue1.length ; i++) {
            dq1.add(queue1[i]);
            dq2.add(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
               
        while(sum1 != sum2) {
            // 큐를 최대 3번까지 순회하며 합 맞출 수 있음
            if(answer >= queue1.length * 3) {
                return -1;
            }
            
            if(sum1 < sum2) {
                int num = dq2.pollFirst();
                dq1.addLast(num);
                sum1 += num;
                sum2 -= num;
            }
            else if(sum1 > sum2) {
                int num = dq1.pollFirst();
                dq2.addLast(num);
                sum2 += num;
                sum1 -= num;
            }
            
            answer++;
        }
                
        return answer;
    }
}