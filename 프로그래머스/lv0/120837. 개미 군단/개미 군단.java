class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        if(hp % 5 != 0) {
            answer += hp/5;
            hp = hp % 5;
            
            if(hp % 3 != 0) {
                answer += hp/3;
                hp = hp % 3;
                
                if(hp % 1 != 0) {
                    answer += hp/1;
                    hp = hp % 1;
                }
                else {
                    answer += hp;
                }
            }
            else {
                answer += hp/3;
            }
            
        }
        else {
            answer += hp/5;
        }
        
        
        return answer;
    }
}