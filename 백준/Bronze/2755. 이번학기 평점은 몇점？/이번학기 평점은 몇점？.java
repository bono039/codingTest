import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.3); map.put("A0", 4.0); map.put("A-", 3.7);
        map.put("B+", 3.3); map.put("B0", 3.0); map.put("B-", 2.7);
        map.put("C+", 2.3); map.put("C0", 2.0); map.put("C-", 1.7);
        map.put("D+", 1.3); map.put("D0", 1.0); map.put("D-", 0.7);
        map.put("F", 0.0);
        
        double hak = 0;    // 학점
        double pyung = 0;  // 평점
        
        int N = Integer.parseInt(br.readLine());
        while(N --> 0) {
            String[] str = br.readLine().split(" ");
            
            hak += Integer.parseInt(str[1]);
            pyung += Integer.parseInt(str[1]) * map.get(str[2]);  // 평점 : 학점 * 성적
        }
        
        System.out.printf("%.2f", pyung / hak);
    }
}