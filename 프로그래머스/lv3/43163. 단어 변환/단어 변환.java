import java.util.*;

class Solution {
    static String begin, target;
    static String[] words;
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        return answer;
    }
    
    private static void dfs(String begin, String target, String[] words, int depth) {
        if(begin.equals(target)) {
            answer = depth;
            return;
        }
        
        for(int i = 0 ; i < words.length ; i++) {
            if(visited[i])  continue;
            
            int k = 0;  // 같은 스펠링 몇 개인지 세기
            for(int j = 0 ; j < begin.length() ; j++) {
                if(begin.charAt(j) == words[i].charAt(j))
                    k++;
            }
            
            // 한 글자 빼고 모두 같은 경우
            if(k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }
}