import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] preArr = new int[n];
        int[] nextArr = new int[n];
        
        for(int i = 0 ; i < n ; i++) {
            preArr[i] = i-1;
            nextArr[i] = i+1;
        }
        nextArr[n-1] = -1;
        
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
                
        for(int i = 0 ; i < cmd.length ; i++) {
            char c = cmd[i].charAt(0);
            
            if(c == 'U') {
                int v = Integer.parseInt(cmd[i].substring(2));
                while(v --> 0) {
                    k = preArr[k];
                }
            }
            else if(c == 'D') {
                int v = Integer.parseInt(cmd[i].substring(2));
                while(v --> 0) {
                    k = nextArr[k];
                }
            }
            // 현재 선택된 행 삭제 후, 바로 아래 행 선택
            // 삭제된 행이 가장 마지막 행이면, 바로 윗 행 선택
            else if(c == 'C') {
                stack.push(new Node(preArr[k], k, nextArr[k]));
                
                if(preArr[k] != -1)    nextArr[preArr[k]] = nextArr[k];
                if(nextArr[k] != -1)   preArr[nextArr[k]] = preArr[k];
                
                sb.setCharAt(k, 'X');
                
                if(nextArr[k] != -1)   k = nextArr[k];
                else                   k = preArr[k];
            }
            // 가장 최근 삭제된 행 원래대로 복구
            else if(c == 'Z') {
                Node now = stack.pop();
                
                if(now.pre != -1)  nextArr[now.pre] = now.cur;
                if(now.next != -1) preArr[now.next] = now.cur;
                sb.setCharAt(now.cur, 'O');
            }
        }
              
        return sb.toString();
    }
}

class Node {
    int pre, cur, next;
    
    public Node(int pre, int cur, int next) {
        this.pre = pre;
        this.cur = cur;
        this.next = next;
    }
}