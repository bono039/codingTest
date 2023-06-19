import java.util.*;
import java.io.*;

public class Main {
    static int N1, N2, T;
    static ArrayList<Node> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ")	    ;
        
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        
        char[] tmp1 = br.readLine().toCharArray();
        for(int i = N1 - 1 ; i >= 0 ; i--) {
            list.add(new Node(tmp1[i], true));
        }
        
        char[] tmp2 = br.readLine().toCharArray();
        for(int i = 0 ; i < N2 ; i++) {
            list.add(new Node(tmp2[i], false));
        }
        
        
        T = Integer.parseInt(br.readLine());
        if(N2 + N1 - 1 <= T) {
            for(int i = 0 ; i < tmp2.length ; i++) {
                sb.append(tmp2[i]);
            }
            
            for(int i = tmp1.length - 1;  i >= 0 ; i--) {
                sb.append(tmp1[i]);
            }
            System.out.println(sb.toString());
            return;
        }
        
        while(T --> 0) {
            for(int i = 0 ; i < list.size() -1 ; i++) {
                Node cur = list.get(i);
                Node next = list.get(i + 1);
                
                if(!cur.team || cur.team == next.team)   continue;
                
                list.set(i, next);
                list.set(i + 1, cur);
                i++;
            }
        }
        
        for(int i = 0 ; i < list.size() ; i++) {
            sb.append(list.get(i).c);
        }
        System.out.println(sb.toString());
	}
}

class Node {
    char c;
    boolean team;
    
    Node(char c, boolean team) {
        this.c = c;
        this.team = team;
    }
}