import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        double max = 0;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        
        double avg = 0;
        double sum = 0;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = arr[i] / max * 100;
            sum += arr[i];
        }
        
        System.out.println(sum / N);
    }
}