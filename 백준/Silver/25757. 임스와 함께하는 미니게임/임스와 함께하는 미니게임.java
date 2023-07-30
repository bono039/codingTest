import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        Set<String> set = new HashSet<>();
        
        while(N --> 0) {
            String name = br.readLine();
            set.add(name);
        }
        
        int answer = 0;
        if(type.equals("Y")) {
            answer = set.size() / 1;
        }
        else if(type.equals("F")) {
            answer = set.size() / 2;
        }
        else if(type.equals("O")) {
            answer = set.size() / 3;
        }
        
        System.out.println(answer);
    }
}