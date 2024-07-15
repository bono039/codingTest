import java.util.*;

class Solution {
    static char[] op = {'+', '-', '*'};
    static boolean[] chk = new boolean[3];
    
    static List<Long> numList = new ArrayList<>();
    static List<Character> opList = new ArrayList<>();
    
    static long answer = 0;
    
    public long solution(String expression) {
        String tmp = "";
        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                tmp += c;
            }
            else {
                numList.add(Long.parseLong(tmp));
                opList.add(c);
                tmp = "";
            }
        }
        numList.add(Long.parseLong(tmp));
        
        dfs(0, "");
        return answer;
    }
    
    private static void dfs(int cnt, String str) {
        if(cnt == 3) {
            solve(str);
            return;
        }
        
        for(int i = 0 ; i < 3 ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                dfs(cnt+1, str+op[i]);
                chk[i] = false;
            }
        }
    }
    
    private static void solve(String str) {
        List<Long> copyNums = new LinkedList<>();
        List<Character> copyOps = new LinkedList<>();
        
        copyNums.addAll(numList);
        copyOps.addAll(opList);
        
        for(int i = 0 ; i < str.length() ; i++) {
            char nowOp = str.charAt(i);
            
            for(int j = 0 ; j < copyOps.size() ; j++) {
                if(copyOps.get(j) == nowOp) {
                    long num = calc(copyNums.get(j), copyNums.get(j+1), nowOp);
                    
                    copyNums.remove(j+1);
                    copyNums.remove(j);
                    copyOps.remove(j);
                    
                    copyNums.add(j, num);
                    j--;
                }
            }            
        }        
        answer = Math.max(answer, Math.abs(copyNums.get(0)));
    }
    
    private static long calc(long x, long y, char c) {
        if(c == '+')
            return x+y;
        else if(c == '-')
            return x-y;
        else if(c == '*')
            return x*y;
        
        return 0;
    }
}