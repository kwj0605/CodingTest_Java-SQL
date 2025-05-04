import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][N];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a-1][b-1] = 1;
        }

        n = sc.nextInt();
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            String s = sc.next();
            q.offer(new Node(a, s));
        }

        Queue<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{0, 0});   // 첫 출발점에서 뱀의 길이 1
        Set<String> bodySet = new HashSet<>();  // 뱀의 몸의 좌표들
        bodySet.add(0 +", "+ 0);    // 출발점 저장

        int time = 0;   // 첫 출발점에서 시작시간 = 1
        int[] dx = {0, 1, 0, -1}; // 처음은 우측, +1하면 우측으로 변환
        int[] dy = {1, 0, -1, 0};
        int vector = 0; // 현재 움직이는 방향

        int x = 0;
        int y = 0;

        while(true) {
            if(!q.isEmpty() && q.peek().num == time) {
                Node node = q.poll();

                if(node.str.equals("D")) vector = (vector+1) % 4;
                else vector = (vector+3) % 4; // 음수가 안나오도록 +4 -1
            }

            // 다음 이동 방향
            int nx = x + dx[vector];
            int ny = y + dy[vector];

            // 밖에 넘었는 지, 꼬리를 닿았는지
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || bodySet.contains(nx+", "+ny)) {
                time++; // 충돌한 시간도 포함
                break;  // 종료
            }

            // 뱀이 움직임
            snake.offer(new int[]{nx, ny});  // 뱀의 길이 증가
            bodySet.add(nx+", "+ny);

            // 사과를 먹을 경우
            if(map[nx][ny] == 1) {
                map[nx][ny] = 0; // 사과 먹은 후 제거
            } else {
                int[] tail = snake.poll();    // 마지막 꼬리를 비워야함.
                bodySet.remove(tail[0] + ", " + tail[1]); // 꼬리위치 삭제
            }
            // 현위치 옮겨줌
            x = nx;
            y = ny;

            time++; // 움직임이 끝나면 시간 증가
        }

        System.out.println(time);
    }
}

class Node {
    int num;
    String str;

    public Node(int n, String s) {
        this.num = n;
        this.str = s;
    }
}