import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] map = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j]; // 최대 높이 구하기
                }
            }
        }
        sc.close();

        int maxArea = 1;
        // 높이 별로 잠기는 곳 확인
        for (int h = 1; h < maxHeight; h++) {
            int count = 0;
            boolean[][] isVisited = new boolean[n][n]; // 높이 변경마다 초기화
            // bfs 로 존재하면 영역 count + 1
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !isVisited[i][j]) { // 높이가 비보다 높고 방문한적 없으면 bfs 시작
                        bfs(map, isVisited, n, i, j, h);
                        count++;
                    }
                }
            }
            maxArea = Math.max(maxArea, count);
        }
        System.out.println(maxArea);
    }

    private static void bfs(int[][] map, boolean[][] isVisited, int n, int x, int y, int h) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[nx][ny] && map[nx][ny] > h) {
                    q.offer(new int[] { nx, ny });
                    isVisited[nx][ny] = true;
                }
            }
        }
    }
}