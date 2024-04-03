import java.util.*;

class Solution {
    static char[] operands = {'+', '-', '*'};
    static boolean[] chk = new boolean[3];
    
    static List<Long> numList = new ArrayList<>();
    static List<Character> operList = new ArrayList<>();
    
    static long answer = 0;
    
    public long solution(String expression) {
        String tmp = "";
        
        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                tmp += c;
            }
            else {
                numList.add(Long.parseLong(tmp));
                tmp = "";
                operList.add(c);
            }
        }
        numList.add(Long.parseLong(tmp));
        
        makeCombinations(0, "");
        return answer;
    }
    
    private static void makeCombinations(int cnt, String str) {
        if(cnt == 3) {
            solve(str);
            return;
        }
        
        for(int i = 0 ; i < 3 ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                makeCombinations(cnt + 1, str + operands[i]);
                chk[i] = false;
            }
        }
    }
    
    private static void solve(String str) {
        List<Long> copyNums = new LinkedList<>();
        List<Character> copyOps = new LinkedList<>();
        
        copyNums.addAll(numList);
        copyOps.addAll(operList);
        
        for(int i = 0 ; i < str.length() ; i++) {
            char nowOp = str.charAt(i);
            
            for(int j = 0 ; j < copyOps.size() ; j++) {
                if(copyOps.get(j) == nowOp) {
                    long res = calc(copyNums.get(j), copyNums.get(j + 1), nowOp);
                    
                    copyNums.remove(j + 1);
                    copyNums.remove(j);
                    copyOps.remove(j);
                    
                    copyNums.add(j, res);
                    j--;
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(copyNums.get(0)));
    }
    
    private static long calc(Long a, Long b, char c) {
        long result = 0;
        
        switch(c) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
        }
        
        return result;
    }
}

class Node {
    char op;
    int idx;
    
    public Node(char op, int idx) {
        this.op = op;
        this.idx = idx;
    }
}