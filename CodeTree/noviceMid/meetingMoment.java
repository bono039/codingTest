import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferdReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
		
      // A 이동
      int[] arr1 = new int[1_000_000];
      int now1 = 0;
      int idx1 = 0;

      // B 이동
      int[] arr2 = new int[1_000_000];
      int now2 = 0;
      int idx2 = 0;

      for(int i = 0 ; i < N ; i++) {
          String[] str = br.readLine().split(" ");
          int move = Integer.parseInt(str[1]);    

          if(str[0].equals("R")) {
              for(int j = 0 ; j < move ; j++) {
                  arr1[++idx1] = ++now1;
              }
          }
          else {
              for(int j = 0 ; j < move ; j++) {
                  arr1[++idx1] = --now1;
              }                
          }
      }

      for(int i = 0 ; i < M ; i++) {
          String[] str = br.readLine().split(" ");
          int move = Integer.parseInt(str[1]);    

          if(str[0].equals("R")) {
              for(int j = 0 ; j < move ; j++) {
                  arr2[++idx2] = ++now2;
              }
          }
          else {
              for(int j = 0 ; j < move ; j++) {
                  arr2[++idx2] = --now2;
              }                
          }
      }

      // 최초로 만나는 시간 출력
      for(int i = 1 ; i <= idx1 ; i++) {
          if(arr1[i] == arr2[i]) {
              System.out.println(i);
              return;
          }
      }

      System.out.println(-1);
    }
}
