import java.util.*;

class Solution {
    static int[] numbers;
    static int target;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);  // 더하기 갯수, 빼기 갯수, 현재 값
        return cnt;
    }
    
    private static void dfs(int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) cnt++;
        }
        else {
            dfs(depth + 1, sum + numbers[depth]);
            dfs(depth + 1, sum - numbers[depth]);
        }
        
    }
}