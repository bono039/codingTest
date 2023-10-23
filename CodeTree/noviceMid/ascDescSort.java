import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

      
        // 1. 오름차순 정렬
        Arrays.sort(arr);
      
        for(int i : arr) sb.append(i + " ");
        sb.append("\n");

      
        // 2. 내림차순 정렬
        Integer[] newArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr, Collections.reverseOrder());
      
        for(Integer i : newArr) sb.append(i + " ");
        sb.append("\n");
 
        System.out.println(sb);        
    }
}
