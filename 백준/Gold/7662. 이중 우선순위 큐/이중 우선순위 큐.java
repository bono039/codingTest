import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            
            while(k --> 0) {
                st = new StringTokenizer(br.readLine(), " ");
                
                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                
                if(cmd.equals("I")) {
                    tree.put(n, tree.getOrDefault(n, 0) + 1);
                }
                else {
                    if(tree.size() == 0) continue;

                    int num = (n == 1) ? tree.lastKey() : tree.firstKey();
                    if(tree.put(num, tree.get(num) - 1) == 1)
                        tree.remove(num);
                }
            }
            
            sb.append(tree.size() == 0 ? "EMPTY" : tree.lastKey() + " " + tree.firstKey());
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
