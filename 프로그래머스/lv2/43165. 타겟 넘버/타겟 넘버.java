import java.util.*;
import java.io.*;

class Solution {    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) answer++;
        }
        else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);  // 해당 노드 값을 더하고 다음 깊이 탐색
            dfs(numbers, target, depth + 1, sum - numbers[depth]);  // 해당 노드 값을 빼고 다음 깊이 탐색
        }
    }
}