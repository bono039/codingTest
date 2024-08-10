import java.util.*;

class Solution {    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, Person> map = new HashMap<>();
        for(String x : enroll) {
            map.put(x, new Person(x, null, 0));
        }
        
        for(int i = 0 ; i < enroll.length ; i++) {
            if(referral[i].equals("-")) { 
                continue;
            }
            
            map.get(enroll[i]).prev = map.get(referral[i]);
        }
        
        for(int i = 0 ; i < seller.length ; i++) {
            map.get(seller[i]).calc(amount[i] * 100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = map.get(enroll[i]).val;
        }        
        return answer;
    }
}

class Person {
    String now;
    Person prev;
    int val;
    
    public Person(String now, Person prev, int val) {
        this.now = now;
        this.prev = prev;
        this.val = val;
    }
    
    // 재귀함수
    public void calc(int val) {
        int profitToParent = val / 10;
        this.val += (val - profitToParent);
        
        if(this.prev != null && profitToParent >= 1) {
            this.prev.calc(profitToParent);
        }
    }
}