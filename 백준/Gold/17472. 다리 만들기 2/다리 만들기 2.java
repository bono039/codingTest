import java.util.*;
import java.io.*;
 
public class Main {
    static int[] dr = {-1, 0, 1, 0};    // 상하 이동 (dy)
    static int[] dc = {0, 1, 0, -1};    // 우좌 이동 (dx)
 
    static int[][] map; 
    static int[] parent;
    static int N, M, sNum; 
    static boolean[][] visited;   // BFS 위한 방문 정보 저장 배열
    
    static ArrayList<ArrayList<int[]>> sumList; // 모든 섬 정보 저장
    static ArrayList<int[]> mlist;              // 1개의 섬 정보 저장
    
    static PriorityQueue<Edge> pq; // 다리 정보 저장
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());   // 가로
        M = Integer.parseInt(st.nextToken());   // 세로
        
        pq = new PriorityQueue<>();
        
        // 맵 정보 저장
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        // 1. BFS 탐색 통해 섬 분리
        sNum = 1;   // 섬 인덱스
        sumList = new ArrayList<>();
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                // 바다 X && 방문 X일 때 같은 섬으로 인식
                if(map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(mlist);
                }
            }
        }
        
        // 2. 섬의 각 지점에서 만들 수 있는 모든 에지 저장
        for(int i = 0 ; i < sumList.size() ; i++) {
            ArrayList<int[]> now = sumList.get(i);  // 1개의 섬 정보
            
            for(int j = 0 ; j < now.size() ; j++) {
                // 1개의 섬의 모든 위치에서 만들 수 있는 다리 정보 저장
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_S = map[r][c];
                
                // 상하좌우 검색
                for(int d = 0 ; d < 4 ; d++) {
                    int tmpR = dr[d];
                    int tmpC = dc[d];
                    int len = 0;
                    
                    while(r + tmpR >= 0 && r + tmpR < N && c + tmpC >= 0 && c + tmpC < M) {
                        // 같은 섬이면 에지 생성 불가
                        if(map[r + tmpR][c + tmpC] == now_S)
                            break;
                        // 같은 섬도 아니고 바다도 아니면 다른 섬
                        else if(map[r + tmpR][c + tmpC] != 0) {
                            if(len >= 2) {
                                pq.add(new Edge(now_S, map[r + tmpR][c + tmpC], len));
                            }
                            break;
                        }
                        // 바다면 다리 길이 연장
                        else {
                            len++;
                        }
                        
                        if(tmpR < 0) tmpR--;
                        else if(tmpR > 0) tmpR++;
                        else if(tmpC < 0) tmpC--;
                        else if(tmpC > 0) tmpC++;
                    }
                }
            }
        }
        
        // 부모 노드 배열 채우기
        parent = new int[sNum];
        for(int i = 0 ; i < parent.length ; i++) {
            parent[i] = i;
        }
        
        // 3. 최소 신장 트리 - 크루스칼
        int useEdge = 0;    // 사용된 에지 수
        int answer = 0;
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();   // 큐에서 에지 정보 가져오기
            
            // 같은 부모가 아니라면 사이클 없으므로 연결
            if(find(now.s) != find(now.e)) {    
                union(now.s, now.e);
                answer += now.v;
                useEdge++;
            }
        }
        
        // 사용된 에지 개수 = 노드 개수 - 1이면 알고리즘 종료
        if(useEdge == sNum - 2) System.out.println(answer);
        else                    System.out.println(-1);
    }
    
    // 유니온파인드
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) parent[b] = a;
    }
    public static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
    
    // BFS 이용해 연결된 섬 탐색
    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        mlist = new ArrayList<>();
        
        int[] start = {i, j};
        q.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            int r = now[0];
            int c = now[1];
            
            // 상하좌우 탐색
            for(int d = 0 ; d < 4 ; d++) {
                int tmpR = dr[d];
                int tmpC = dc[d];
                
                
                while(r + tmpR >= 0 && r + tmpR < N && c + tmpC >= 0 && c + tmpC < M) {
                    // 방문 X & 바다X면 같은 섬 취급
                    if(visited[r + tmpR][c + tmpC] == false && map[r + tmpR][c + tmpC] != 0) {
                        addNode(r + tmpR, c + tmpC, q);
                    } else break;
                    
                    if(tmpR < 0)      tmpR--;
                    else if(tmpR > 0) tmpR++;
                    else if(tmpC < 0) tmpC--;
                    else if(tmpC > 0) tmpC++; 
                }
            }
        }
    }
    
    // 특정 위치를 섬의 정보로 넣는 함수
    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] tmp = {i, j};
        mlist.add(tmp);
        queue.add(tmp);
    }
 
}
 
class Edge implements Comparable<Edge> {
    int s, e, v;
    
    Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    
    // 가중치 오름차순 정렬
    @Override
    public int compareTo(Edge p) {
        return this.v - p.v;
    }
}
