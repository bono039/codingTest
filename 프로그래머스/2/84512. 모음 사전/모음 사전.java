import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static String word;
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        this.word = word;
        
        dfs(0, 0, "");
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    private static void dfs(int idx, int cnt, String s) {
        if(cnt == 5) {
            if(!list.contains(s)) {
                list.add(s);         
            }
            return;
        }
        
        for(int i = 0 ; i < 5 ; i++) {
            dfs(i + 1, cnt + 1, s + words[i]);
            
            if(!list.contains(s + words[i])) 
                list.add(s + words[i]);
        }
    }
}