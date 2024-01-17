import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        LinkedList<Integer> pq = new LinkedList<>();
        
        for(int i = 0 ; i < operations.length ; i++) {
            String[] s = operations[i].split(" ");
            
            String cmd = s[0];
            int num = Integer.parseInt(s[1]);
            
            if(cmd.equals("I")) {
                pq.add(num);
                Collections.sort(pq);
            }
            else if(cmd.equals("D")) {
                if(pq.isEmpty())    continue;
                
                if(num == 1)
                    pq.removeLast();
                else
                    pq.removeFirst();
            }            
        }
                
        // 출력하기
        if(pq.isEmpty()) {
            answer = new int[] {0,0};
        }
        else {
            answer = new int[] {pq.pollLast(), pq.pollFirst()};
        }
        
        return answer;
    }
}