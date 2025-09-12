import java.util.*;

class Solution {
    public int solution(String[] board) {        
        int h = board.length;
        int w = board[0].length();
        
        String[][] map = new String[h][w];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i=0; i<h; i++) {
            map[i] = board[i].split("");
        }
        
        int sX = -1, sY = -1;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j].equals("R")) {
                    sX = i;
                    sY = j;
                    break;
                }
            }
            if(sX!=-1) break;
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[h][w];
        q.offer(new int[]{sX, sY, 0}); // x좌표, y좌표, 움직인 값
        isVisited[sX][sY] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            int nx = now[0];
            int ny = now[1];
            int move = now[2];
            
            if(map[nx][ny].equals("G")) {
                return move;
            }
            
            for(int i=0; i<4; i++) {
                int nextX = nx; // 기존 방향으로 끝까지 갔을 때 틀렸으면 이동 전 좌표에서 가야함.
                int nextY = ny;
                
                while(true) {
                    int tempX = nextX + dx[i];
                    int tempY = nextY + dy[i];
                    if(tempX < 0 || tempX >= h || tempY < 0 || tempY >= w || map[tempX][tempY].equals("D")) {
                        break;
                    }
                    
                    nextX = tempX;
                    nextY= tempY;
                }
                
                if(!isVisited[nextX][nextY]) {
                    q.offer(new int[]{nextX, nextY, move+1});
                    isVisited[nextX][nextY] = true;
                }
            }
        }        
        
        return -1;
    }
}


// R찾기
// bfs 로 끝까지 가기
// 방문한 곳에 또 방문하면 안됨. 방문한 곳만 가지면 -> -1 반환
// 방문은 끝에만 방문처리