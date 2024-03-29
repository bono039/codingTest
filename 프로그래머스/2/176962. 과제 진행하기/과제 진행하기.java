import java.util.*;

class Solution {    
    public String[] solution(String[][] plans) {
        Plan[] pp = new Plan[plans.length];
        for(int i = 0 ; i < plans.length ; i++) {
            pp[i] = new Plan(plans[i]);
        }        
        Arrays.sort(pp, (a, b) -> a.start - b.start);
        
        Stack<Plan> stop = new Stack<>(); // 잠시 멈춘 과제 리스트
        List<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < pp.length -1 ; i++) {
            Plan now = pp[i];
            Plan next = pp[i+1];
                        
            if(now.getEndTime() > next.start) {  // 과제 잠시 멈춰야 하는 경우
                now.playTime = now.getEndTime() - next.start;
                stop.push(now);
                continue;
            }
            list.add(now.name);
            
            int restTime = next.start - now.getEndTime();
            
            while(restTime > 0 && !stop.isEmpty()) {
                Plan stopPlan = stop.peek();
                
                int timeDiff = stopPlan.playTime - restTime;
                stopPlan.playTime = timeDiff;
                restTime = timeDiff * -1;
                
                if(timeDiff > 0)    break;
                
                list.add(stop.pop().name);                
            }
        }
        
        list.add(pp[pp.length -1].name);
        
        while(!stop.isEmpty())
            list.add(stop.pop().name);       
        
        return list.toArray(new String[list.size()]);
    }
}

class Plan {
    String name;
    int start;
    int playTime;
    
    public Plan(String name, String start, String playTime) {
        this.name = name;
        String[] t = start.split(":");
        this.start = Integer.parseInt(t[0]) *60 + Integer.parseInt(t[1]);
        this.playTime = Integer.parseInt(playTime);
    }
    
    public Plan(String[] plan) {
        this(plan[0], plan[1], plan[2]);
    }
    
    public int getEndTime() {
        return start + playTime;
    }
}