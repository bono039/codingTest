class Solution {
    public int solution(int[] numbers) {
        int[] num = new int[10];
        int answer = 0;
        
        for(int i : numbers) {
            num[i]++;
        }
        
        for(int i=0 ; i < num.length ; i++) {
            if(num[i] == 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}