import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chickens.size()];
        combination(0, 0);
        System.out.println(min);
    }

    private static void combination(int start, int cnt) {
        if (cnt == M) {
            min = Math.min(min, calculateDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if(!selected[i]) {
                selected[i] = true;
                combination(i + 1, cnt + 1);
                selected[i] = false;
            }
        }
    }

    private static int calculateDistance() {
        int total = 0;

        for (int[] house : houses) {
            int sum = Integer.MAX_VALUE;
            
            for (int i = 0; i < chickens.size(); i++) {
                if(selected[i]) {
                    int[] chicken = chickens.get(i);
                    int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    
                    sum = Math.min(sum, distance);
                }
            }
            total += sum;
        }

        return total;
    }
}
