import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        // 1. 이진수 -> 십진수로 바꾸기
        int tmp = 0;
        for(int i = 0 ; i < num.length() ; i++) {
            if(num.charAt(i) == '1')
                tmp += Math.pow(2, num.length() - i - 1);
        }

        // 2. 17배 하기
        int seventeen = tmp * 17;
        
        // 3. 다시 이진수로 나타내기
        String str = Integer.toBinaryString(seventeen);

        System.out.println(str);
    }
}
