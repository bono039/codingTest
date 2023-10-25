import java.util.*;
// 조합 (DFS)
class Solution {
    static int[] numbers;
    static int target;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return cnt;
    }
    
    private static void dfs(int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }

        // 현재 숫자를 더한 / 뺀 경우로 나눠 재귀 호출
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);

    }
}