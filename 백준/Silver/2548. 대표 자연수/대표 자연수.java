import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));

        int N = Integer.parseInt((br.readLine()));

        int[] arr = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        
        int tmp1 = (arr.length % 2 == 0) ? arr[arr.length / 2 - 1] : arr[arr.length / 2];  // -1은 나중에 생각해
        int diffSum = 0;
        for(int i = 0 ; i < N ; i++) {
            diffSum += Math.abs(arr[i] - tmp1);
        }

        int avg = sum / arr.length;
        int tmp2 = 0;
        for(int i : arr) {
            tmp2 += Math.abs(avg - i);
        }

        if(tmp1 >= tmp2) {
            System.out.println(avg);
        }
        else {
            System.out.println(tmp1);
        }
    }
}
