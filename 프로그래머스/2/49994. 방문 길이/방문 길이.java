class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        int d = 0;
        
        for(char dir : dirs.toCharArray()) {
            if(dir == 'U') d = 0;
            if(dir == 'D') d = 2;
            if(dir == 'L') d = 1;
            if(dir == 'R') d = 3;
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if(nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;
            if(!visited[ny][nx][d]) {
                visited[ny][nx][d] = true;
                visited[y][x][(d+2)%4] = true; // 반대방향에서 오는 것도 체크
                answer++;
            }
            y = ny;
            x = nx;
        }
        return answer;
    }
}