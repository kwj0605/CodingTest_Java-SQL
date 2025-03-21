import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int h=maps.length;
        int w=maps[0].length;
        
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        
        Queue<int[]> q=new LinkedList<>();
        int[][] dis = new int[h][w];
        
        q.offer(new int[]{0,0});
        dis[0][0]=1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++) {
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(0<=nx && 0<=ny && nx<h && ny<w && dis[nx][ny] == 0 && maps[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    dis[nx][ny] = dis[now[0]][now[1]] + 1;
                }
            }
        }
        if(dis[h-1][w-1] != 0) {
            answer = dis[h-1][w-1];
        } else {
            answer = -1;
        }
        
        return answer;
    }
}