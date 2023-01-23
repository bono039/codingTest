class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        // Max 길이를 구하고
        int max = sides[0];
        int idx = 0;
        
        for(int i=0 ; i<sides.length ; i++) {
            if(sides[i] > max) {
                max = sides[i];
                idx = i;
            }
        }
        
        // 나머지 두 변 길이 합이랑 비교
        if(idx == 0) {
            if((sides[1]+sides[2]) > max) answer = 1;
            else                          answer = 2;
        }
        else if(idx == 1) {
            if((sides[0]+sides[2]) > max) answer = 1;
            else                          answer = 2;
        }
        else if(idx == 2) {
            if((sides[0]+sides[1]) > max) answer = 1;
            else                          answer = 2;
        }
        
        return answer;
    }
}