import java.util.*;

class Solution {
    static String[] user_id, banned_id;
    static boolean[] chk;
    static Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        chk = new boolean[banned_id.length];
        dfs(0, new HashSet<>());       
        
        return result.size();
    }
    
    private static void dfs(int depth, Set<String> set) {
        if(depth == banned_id.length) {
            result.add(set);
            return;
        }
        
        for(int i = 0 ; i < user_id.length ; i++) {
            if(set.contains(user_id[i]))    continue;
            
            if(match(user_id[i], banned_id[depth])) {
                set.add(user_id[i]);
                dfs(depth + 1, new HashSet<>(set));
                set.remove(user_id[i]);
            }
        }
    }
    
    private static boolean match(String uId, String bId) {
        if(uId.length() != bId.length()) return false;
        
        for(int i = 0 ; i < uId.length() ; i++) {
            if(bId.charAt(i) != '*' && uId.charAt(i) != bId.charAt(i))
                    return false;
        }
        
        return true;
    }
}