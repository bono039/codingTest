import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[1_000_001]; 
        int pos1 = 0;
        int time1 = 0;

        int[] arr2 = new int[1_000_001];
        int pos2 = 0;
        int time2 = 0;

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int speed = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < time ; j++) {
                pos1 += speed;
                arr1[++time1] = pos1;
                //System.out.println("arr1 : " + time1 + " " + pos1);
            }          
        }

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int speed = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < time ; j++) {
                pos2 += speed;
                arr2[++time2] = pos2;
                //System.out.println("arr2 : " + time2 + " " + pos2);
            }
        }

        int cnt = 0;
        int[] first = new int[time1 + 1];
        for(int i = 1 ; i < first.length ; i++) {
            if(arr1[i] >= arr2[i]) {
                first[i] = 1;
            }
            else {
                first[i] = 2;
            }
            
        }

        for(int i = 1 ; i < time1 ; i++) {
            if(first[i] != first[i + 1]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
