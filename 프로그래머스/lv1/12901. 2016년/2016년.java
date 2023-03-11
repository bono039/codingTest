class Solution {
    public String solution(int a, int b) {
        String answer = "";
        // 1.1 -> 금
        String[] yoil = {"FRI","SAT","SUN","MON","TUE","WED","THU"};    
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day = 0;
        
        for(int i=0 ; i < a-1 ; i++) {
            day += date[i];
        }

        day += (b - 1);
        answer += yoil[day % 7];
        
        return answer;
    }
}