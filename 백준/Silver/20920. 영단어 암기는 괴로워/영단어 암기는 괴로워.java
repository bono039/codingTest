import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        /*** 입력 받기 ***/
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        
        while(N --> 0) {
            String word = br.readLine();

            if(word.length() < M)   continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
           int tmp = o2.getValue() - o1.getValue();
           if(tmp != 0) return tmp;
           else {
               int len = o2.getKey().length() - o1.getKey().length();
               
               if(len != 0) return len;
               else {
                   int word = o1.getKey().compareTo(o2.getKey());
                   return word;
               }
           }
        });

        for(Map.Entry<String, Integer> s : list) {
            sb.append(s.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}