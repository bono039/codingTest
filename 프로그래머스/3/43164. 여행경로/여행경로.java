import java.util.*;

class Solution {
    static String[][] tickets;
    
    static boolean[] visited;
    static List<String> routeList = new ArrayList<>();
    static int cnt = 0;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        
        visited = new boolean[tickets.length];        
        
        dfs("ICN", "ICN", 0);   // 시작점, 끝점, 정해진 갯수
        
        Collections.sort(routeList);
        
        String[] answer = routeList.get(0).split(" ");
        return answer;
    }
    
    private static void dfs(String from, String to, int depth) {
        if(depth == tickets.length) {
            routeList.add(to);
            return;
        }
        
        for(int i = 0 ; i < tickets.length ; i++) {
            if(!visited[i] && from.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], to + " " + tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}