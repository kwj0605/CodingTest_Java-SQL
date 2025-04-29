import java.util.*;

class Solution {
    int n, m;
    int[] oil;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        int answer = -1;
        
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        
        boolean[][] visit = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1 && !visit[i][j]) {
                    bfs(land, visit, i, j);
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            answer = Math.max(oil[i], answer);
        }
        
        return answer;
    }
    
    void bfs(int[][] land, boolean[][] visit, int x, int y) {
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        
        visit[x][y] = true;
        set.add(y);
        int count = 1;
        
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && land[nx][ny] == 1 && !visit[nx][ny]) {
                    set.add(ny);
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }
        
        for(int s : set) {
            oil[s] += count;
        }
    }
}