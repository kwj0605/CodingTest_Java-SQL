import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] dx = {0, 0, -1, 1}; // 상하좌우 좌표 설정
    static final int[] dy = {1, -1, 0, 0}; // 상하좌우 좌표 설정
    static int N, M;
    static int[][] lab;
    static int maxSafeZone = Integer.MIN_VALUE; // 최대값을 찾기 위해 최소값 설정ㅈ

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
            }
        }
        sc.close();

        makeWall(0);

        System.out.println(maxSafeZone);
    }

    static void makeWall(int count) {
        // 벽 3개 세우면 바이러스 뿌리기
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    makeWall(count + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        Queue<Node> q = new LinkedList<>();
        // 바이러스 좌표 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        // 바이러스 뿌리기 위한 클론 랩 생성(원래 랩 변경 방지)
        int[][] cloneLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            cloneLab[i] = lab[i].clone();
        }

        // 바이러스 뿌리기
        while (!q.isEmpty()) {
            // 현재 바이러스 위치 가져오기
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            // 바이러스가 퍼지는 다음 좌표
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 연구소 밖이 아니고 벽이 아니면 2로 변환하고 바이러스 위치 추가
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (cloneLab[nx][ny] == 0) {
                        cloneLab[nx][ny] = 2;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }

        // safeZone 개수 새기
        countSafeZone(cloneLab);
    }

    static void countSafeZone(int[][] cloneLab) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneLab[i][j] == 0) {
                    count++;
                }
            }
        }
        if (maxSafeZone < count) {
            maxSafeZone = count;
        }
    }

    // (x, y)좌표를 넣기 위한 클래스
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// 0. 행열을 만들어야함.
// 1. 벽을 세워야함
// 2. 바이러스를 퍼뜨러야함
// 3. 가장 안전구역이 많은 걸 초이스