import java.util.*;

class Main {

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static char[][] map;
    static boolean[][][][] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        map = new char[n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if (c == 'R') {
                    rx = i;
                    ry = j;
                }
                if (c == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        sc.close();

        check = new boolean[n][m][n][m];

        bfs(rx, ry, bx, by, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void bfs(int rx, int ry, int bx, int by, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { rx, ry, bx, by, cnt });
        check[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int ncnt = now[4];

            if (ncnt >= 10)
                return;

            for (int i = 0; i < 4; i++) {
                int nrx = now[0];
                int nry = now[1];
                int nbx = now[2];
                int nby = now[3];

                // 빨간 구슬 이동
                while (map[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    if (map[nrx][nry] == 'O')
                        break;
                }

                // 파란 구슬 이동
                while (map[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    if (map[nbx][nby] == 'O')
                        break;
                }

                // 파란 구슬이 구멍에 들어갔을 때
                if (map[nbx][nby] == 'O')
                    continue;

                // 파란 구슬은 안들어가고 빨간 구슬이 들어갔을 때
                if (map[nrx][nry] == 'O') {
                    min = ncnt + 1;
                    return;
                }

                // 파란구슬과 빨간구슬이 곂쳤을 때
                if (nrx == nbx && nry == nby) {
                    // 늦게 도착한 구슬을 뒤로 무름
                    int redMove = Math.abs(nrx - now[0]) + Math.abs(nry - now[1]);
                    int blueMove = Math.abs(nbx - now[2]) + Math.abs(nby - now[3]);

                    if (redMove < blueMove) {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                    if (blueMove < redMove) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    }
                }

                // 이동 후 check 에 없으면 q에 추가
                if (!check[nrx][nry][nbx][nby]) {
                    check[nrx][nry][nbx][nby] = true;
                    q.offer(new int[] { nrx, nry, nbx, nby, ncnt + 1 });
                }
            }
        }
    }
}
