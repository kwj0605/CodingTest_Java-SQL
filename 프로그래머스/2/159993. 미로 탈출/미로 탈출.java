import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int h = maps.length;
        int w = maps[0].length();
        
        int sx = -1;
        int sy = -1;
        
        int sx2 = -1;
        int sy2 = -1;
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                    continue;
                }
                if(maps[i].charAt(j) == 'L') {
                    sx2 = i;
                    sy2 = j;
                }
            }
            if(sx != -1 && sx2 != -1) break;
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[h][w];
        q.offer(new int[]{sx, sy, 0}); // 시작 점 좌표, 이동 시간
        isVisited[sx][sy] = true;
        // boolean turnOnLever = false; // 레버 작동 유무
        
        int leverTime = Integer.MAX_VALUE; // 레버까지 도달하는 시간
        int endTime = Integer.MAX_VALUE; // 엔드까지 도달하는 시간
        
        while(!q.isEmpty()) { // 레버까지 최소시간 구하기
            int[] now = q.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=h || ny<0 || ny>=w || isVisited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                isVisited[nx][ny] = true;
                q.offer(new int[]{nx, ny, now[2]+1});

                if(maps[nx].charAt(ny) == 'L') {
                    // turnOnLever = true;
                    leverTime = Math.min(leverTime, now[2]+1);
                    // leverTime = Math.min(now[2]+1, leverTime);
                    
                    // isVisited = new boolean[h][w]; // 초기화
                    // q.poll(); // 이전에 넣은걸 빼고 거리를 다시 초기화해줘야함.
                    // q.offer(new int[]{nx, ny, 0}); // L에서 E까지 거리 다시 측정
                    // break;
                }
            } 
        }
        
        isVisited = new boolean[h][w]; // 초기화
        
        q.offer(new int[]{sx2, sy2, 0});
        isVisited[sx2][sy2] = true;
        while(!q.isEmpty()) { // 레버가 작동했을 때 E까지 최소거리 구하기
            int[] now = q.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=h || ny<0 || ny>=w || isVisited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                isVisited[nx][ny] = true;
                q.offer(new int[]{nx, ny, now[2]+1});

                if(maps[nx].charAt(ny) == 'E') {
                    endTime = Math.min(endTime, now[2]+1);
                }
            }
        }
        
        if(leverTime != Integer.MAX_VALUE && endTime != Integer.MAX_VALUE) {
            answer = leverTime + endTime;
        }
        
        return answer;
    }
}

// L쪽을 방문하고 E를 가야 나갈 수 있음. (최소값 찾기) -> BFS
// S에서 시작하고 X는 지나갈 수 없음.
// L에 도착하면 isVisited를 초기화해야함 ( 왔다가는 경우가 있기 떄문 )