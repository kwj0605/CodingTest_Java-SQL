class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 1. park로 map제작
        String[][] map = new String[park.length][park[0].length()];
        
        for(int i=0; i<park.length; i++) {
            map[i] = park[i].split("");
        }
        
        // 시작 좌표 검색
        int[] start = new int[2];
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        
        // 2. routes 실행
        int ny = start[0], nx = start[1];
        for(String route : routes) {
            // " "로 파싱하여 방향과, 이동 수 분리
            String[] str = route.split(" ");
        
            // 현재지점에서 명령어 수행
            // 명령이 공원을 벗어나거나, 장애물이 있으면 해당 명령어 취소
            boolean canMove = true; // 이동할 수 있는 지 확인
            if(str[0].equals("N")) { // 상
                for(int i=1; i<=Integer.parseInt(str[1]); i++) {
                    if(ny-i < 0) {
                        canMove = !canMove;
                        break;
                    }
                    if(map[ny-i][nx].equals("X")) {
                        canMove = !canMove;
                        break;
                    }
                }
                if(canMove) {
                    ny=ny-Integer.parseInt(str[1]);
                }
            } else if(str[0].equals("E")) { // 우
                for(int i=1; i<=Integer.parseInt(str[1]); i++) {
                    if(nx+i >= map[0].length) {
                        canMove = !canMove;
                        break;
                    }
                    if(map[ny][nx+i].equals("X")) {
                        canMove = !canMove;
                        break;
                    }
                }
                if(canMove) {
                    nx=nx+Integer.parseInt(str[1]);
                }
            } else if(str[0].equals("S")) { // 하
                for(int i=1; i<=Integer.parseInt(str[1]); i++) {
                    if(ny+i >= map.length) {
                        canMove = !canMove;
                        break;
                    }
                    if(map[ny+i][nx].equals("X")) {
                        canMove = !canMove;
                        break;
                    }
                }
                if(canMove) {
                    ny=ny+Integer.parseInt(str[1]);
                }
            } else { // 좌
                for(int i=1; i<=Integer.parseInt(str[1]); i++) {
                    if(nx-i < 0) {
                        canMove = !canMove;
                        break;
                    }
                    if(map[ny][nx-i].equals("X")) {
                        canMove = !canMove;
                        break;
                    }
                }
                if(canMove) {
                    nx=nx-Integer.parseInt(str[1]);
                }
            }
        }
        
        
        // 명령이 끝난 후 [세로 좌표, 가로 좌표] return
        answer[0] = ny;
        answer[1] = nx;
        return answer;
    }
}