import java.util.*;

class Solution {
    static String numbers;
    static int len;
    
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        len = numbers.length();
        visited = new boolean[len];
        
        for(int i = 1 ; i <= len ; i++) {
            dfs(0, i, "");
        }
        
        return set.size();
    }
    
    private static void dfs(int cnt, int target, String s) {
        if(cnt == target) {
            int num = Integer.parseInt(s);
            
            if(isPrime(num)) {
                set.add(num);
                return;
            }
        }
        
        for(int i = 0 ; i < len ; i++) {
            if(!visited[i]){
                s += numbers.charAt(i);
                visited[i] = true;
                dfs(i + 1 , target, s);
                
                visited[i] = false;
                s = s.substring(0, s.length() - 1);   
            }
        }
    }
    
    private static boolean isPrime(int num) {
        if(num <= 1)    return false;
        
        for(int i = 2 ; i <= (int)Math.sqrt(num) ; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}