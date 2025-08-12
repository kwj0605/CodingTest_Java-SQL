import java.util.*;

class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visit;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;
    
    private static void dfs(int x, int y, int idx, int sum) {
        if(idx == 4) {
            max = Math.max(max, sum);
            return;
        }

        
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
                
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                // ㅗ모양 테트로미노
                if(idx == 2) {
                    visit[nx][ny] = true;
                    dfs(x, y, idx+1, sum + map[nx][ny]);
                    visit[nx][ny] = false;
                }
                visit[nx][ny] = true;
                dfs(nx, ny, idx+1, sum + map[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visit = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 1. map 전체 탐색
        // 2. DFS로 킨 4개 가능한 합
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
        // 시간 복잡도 : 500 * 500 * 4*4*4*4 = 1000000(6400만)
    }
}