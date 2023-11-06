import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int min = Integer.MAX_VALUE;
  static int[] arr;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
  
    st = new StringTokenizer(br.readLine()," ");
    for(int i = 0 ; i < N ; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    for(int i = 0 ; i < N ; i++) {
      int tmp = 0;
  
      for(int j = 0 ; j < N ; j++) {
        tmp += arr[j] * Math.abs(j - i);
      }
  
      min = Math.min(min, tmp);
    }
  
    System.out.println(min);
  }
}
