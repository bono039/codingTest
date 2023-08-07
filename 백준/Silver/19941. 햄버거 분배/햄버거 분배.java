import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] cmd = br.readLine().toCharArray();
        boolean[] isUsed = new boolean[cmd.length];

        int cnt = 0;
        for(int i = 0 ; i < N ; i++) {
            if(cmd[i] == 'P') {
                for(int j = i - K ; j <= i + K ; j++) {
                    if(0 <= j && j < N && cmd[j] == 'H' && !isUsed[j]) {
                        isUsed[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}