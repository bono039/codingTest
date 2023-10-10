class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int tmp1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int tmp2 = 2 * a * b;
        
        return answer = (tmp1 >= tmp2) ? tmp1 : tmp2;
    }
}