import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;    // 다리 건너는 트럭 무게들 합
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int t : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }
                else if(q.size() == bridge_length) {
                    sum -= q.poll();
                }
                else {
                    if(sum + t > weight) {
                        q.offer(0);
                        answer++;
                    }
                    else {
                        q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}