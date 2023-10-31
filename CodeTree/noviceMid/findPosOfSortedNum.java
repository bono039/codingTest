import java.util.*;
import java.io.*;

class Number implements Comparable<Number> {
    int num, pos;

    public Number(int num, int pos) {
        this.num = num;
        this.pos = pos;
    }

    @Override
    public int compareTo(Number n) {
        if(this.num == n.num)    // 동일한 원소의 경우, 먼저 입력으로 주어진 원소를 앞으로
            return this.pos - n.pos;
        return this.num - n.num;    // 숫자 기준 오름차순 정렬
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        Number[] numbers = new Number[N];
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            nums[i] = n;
            numbers[i] = new Number(n, i + 1);
        }

        Arrays.sort(numbers);

        boolean[] visited = new boolean[N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < numbers.length ; j++) {
                if(!visited[j] && nums[i] == numbers[j].num) {
                    System.out.print(j + 1 + " ");
                    visited[j] = true;
                    break;
                }
            }
        }
    }
}
