import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0; // 필요한 작업의 최소 횟수
        
        long sum1 = 0;
        long sum2 = 0;
        
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        
        for(int i = 0 ; i < queue1.length ; i++) {
            deque1.add(queue1[i]);
            deque2.add(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        
        long target = (sum1 + sum2) / 2;
        
        while(sum1 != sum2) {
            // 큐를 최대 3번까지 순회하며 합 맞출 수 있음
            if(answer >= queue1.length * 3) {
                return -1;
            }
            
            if(sum1 < sum2) {
                deque1.addLast(deque2.peekFirst());
                sum1 += deque2.peekFirst();
                
                sum2 -= deque2.pollFirst();
            }
            else if(sum1 > sum2) {
                deque2.addLast(deque1.peekFirst());
                sum2 += deque1.peekFirst();
                
                sum1 -= deque1.pollFirst();
            }
            
            answer++;
        }        
        
        return answer;
    }
}