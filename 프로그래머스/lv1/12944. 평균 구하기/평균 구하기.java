class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        for(int i : arr) {
            answer += (double)i;
        }
        
        return answer / arr.length;
    }
}