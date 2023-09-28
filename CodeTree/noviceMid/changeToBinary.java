import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        //System.out.println(Integer.toBinaryString(num));

        int[] digits = new int[100_000];
        int cnt = 0;

        while(true) {
            if(num < 2) {
                digits[cnt++] = num;
                break;
            }

            digits[cnt++] = num % 2;
            num /= 2;
        }

        for(int i = cnt - 1 ; i >= 0 ; i--) {
            System.out.print(digits[i]);
        }
    }
}
