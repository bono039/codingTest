import java.util.*;

class Solution {
    static String[][] relation;
    static boolean[] visited;
    static List<String> list = new LinkedList<>();
    
    static int answer = 0;  // 후보키 최대 개수
    
    public int solution(String[][] relation) {
        this.relation = relation;
        
        // 속성 1~N개씩 다 선택해서 
        for(int i = 0 ; i < relation.length ; i++) {
            visited = new boolean[relation[0].length];
            dfs(i + 1, 0, 0);
        }
        
        answer = list.size();
        return answer;
    }
    
    private static void dfs(int target, int idx, int depth) {
        if(depth == target) {
            List<Integer> tmpList = new ArrayList<>();
            String key = "";
            
            for(int i = 0 ; i < visited.length ; i++) {
                if(visited[i]) {
                    key += String.valueOf(i);
                    tmpList.add(i);
                }
            }
            
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0 ; i < relation.length ; i++) {
                String str = "";
                
                for(int j : tmpList) {
                    str += relation[i][j];
                }
                
                if(map.containsKey(str))  return;
                map.put(str, 0);
            }
            
            // 후보키 추가
            for(String s : list) {
                int cnt = 0;
                
                for(int i = 0 ; i < key.length() ; i++) {
                    String subS = String.valueOf(key.charAt(i));
                    
                    if(s.contains(subS)) cnt++;
                }
                
                if(cnt == s.length())   return;
            }
            list.add(key);
            
            return;
        }
        
        for(int i = idx ; i < visited.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(target, i, depth + 1);
                visited[i] = false;
            }
        }
    }
}