import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));

        int N = Integer.parseInt((br.readLine()));

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int mid = (arr.length % 2 == 0) ? arr[arr.length / 2 - 1] : arr[arr.length / 2];  // -1은 나중에 생각해
        System.out.println(mid);
    }
}
