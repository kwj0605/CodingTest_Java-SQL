import java.util.*;

class Solution {
    int n;
    int m;
    int[] oil;
    
    // 상하좌우
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        int answer = -1;
        
        n = land.length; 
        m = land[0].length;
        oil = new int[m];
        
        boolean[][] isVisited = new boolean[n][m]; // 방문
        
        // 1. land 전부탐색하며
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1 && !isVisited[i][j]) {
                    bfs(land, isVisited, i, j);
                }
            }
        }
        
        // 4. 열 중에서 가장 많은 석유량을 추출할 수 있는 량
        for(int i : oil) {
            answer = Math.max(answer, i);
        }
        
        return answer;
    }
    
    void bfs(int[][] land, boolean[][] isVisited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});   // 현재 위치
        isVisited[x][y] = true; // 방문처리
        
        int count = 1;      // 석유의 량
        Set<Integer> set = new HashSet<>();     // 열의 정보
        
        // 2. 석유가 있는 지역의 "열"에 석유의 량을 저장 -> 배열에 저장, 열은 중복될 수 있으므로 set에 저장
        while(!q.isEmpty()) {
            int[] now = q.poll();
            set.add(now[1]);    // 석유가 있던 열의 위치 저장
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                // 맵의 범위를 벗어났을 때
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                
                // 오일이고 방문하지 않은 곳일 때
                if(land[nx][ny] == 1 && !isVisited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    isVisited[nx][ny] = true;   // 방문처리
                    count++;    // 석유의 량 증가
                }
            }
        }
        
        // 3. 각 열의 오일량을 저장
        for(int idx : set) {
            oil[idx] += count;
        }
    }
}