// storage : 컨테이너 정보
// requests: 출고할 컨테이너
// 테두리 채우기
// if(requests[0].length == 1)
// 외부와 연결된 컨테이너 찾기 BFS
// 한번에 (" ")로 대체
// else 모두 탐색해서 (" ")
import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        String[][] map = new String[storage.length + 2][storage[0].length() + 2];
        
        // 테두리 채우기, 외부 만들기
        for(int i=0; i<storage.length + 2; i++) {
            for(int j=0; j<storage[0].length() + 2; j++) {
                if(i == 0 || j == 0 || i == storage.length+1 || j == storage[0].length()+1) {
                    map[i][j] = " ";
                }
            }
        }
        // 컨테이너 map 채우기
        for(int i=1; i<=storage.length; i++) {
            for(int j=1; j<=storage[0].length(); j++) {
                map[i][j] = String.valueOf(storage[i-1].charAt(j-1));
            }
        }
        
        // 출고할 컨테이너 꺼내기
        for(int i=0; i<requests.length; i++) {
            // 지게차 사용
            if(requests[i].length() == 1) {
                bfs(map, requests[i]);
            } else { // 크레인 사용
                for(int x=0; x<map.length; x++) {
                    for(int y=0; y<map[0].length; y++) {
                        if(map[x][y].equals(String.valueOf(requests[i].charAt(0)))) {
                            map[x][y] = " ";
                            System.out.println("크레인 출고: "+x+", "+y);
                        }
                    }
                }
            }
        }
        
        // 남은 컨테이너 수
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(!map[i][j].equals(" ")) answer++; 
            }
        }        
        
        return answer;
    }
    
    void bfs(String[][] map, String target) {
        int[] dx = {0, 0, -1, 1}; // 상하좌우
        int[] dy = {1, -1, 0, 0}; // 상하좌우
        Queue<Node> q = new LinkedList<>();
        boolean[][] isAccessable = new boolean[map.length][map[0].length];
        boolean[][] outside = new boolean[map.length][map[0].length];
        
        // 외부의 정보를 BFS로 outside에 넣음
        q.offer(new Node(0,0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            int nx = now.x;
            int ny = now.y;
            
            for(int i=0; i<4; i++) {
                int x = nx+dx[i];
                int y = ny+dy[i];
                
                // map안에 있고 outside가 아닌데 " "로 표시된거
                if(0<=x && x<map.length && 0<=y && y<map[0].length && !outside[x][y] && map[x][y].equals(" ")) {
                    outside[x][y] = true;
                    q.offer(new Node(x, y));
                }
            }
        }
        
        // map에서 target을 찾아서 외부와 인접한지 확인
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals(target)) {
                    int nx = i;
                    int ny = j;

                    for(int k=0; k<4; k++) {
                        int x = nx+dx[k];
                        int y = ny+dy[k];
                        if(outside[x][y]) {
                            isAccessable[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        // 컨테이너 출고하기
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(isAccessable[i][j]) {
                    map[i][j] = " ";
                    System.out.println("지게차 출고: "+i+", "+j);
                }
                
            }
        }
    }
}

class Node{
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}