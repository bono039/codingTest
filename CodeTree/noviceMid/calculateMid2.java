import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            Collections.sort(list);
            
            if(i % 2 == 1) {
                sb.append(list.get(i / 2)).append(" ");
            }
        }
 
        System.out.println(sb);
    }
}
