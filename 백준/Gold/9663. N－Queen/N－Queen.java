import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.close();

        map = new int[N][N]; // N번째 열 값이 행을 표현현

        backtrack(0);

        System.out.println(result);
    }

    private static void backtrack(int depth) {
        // isSolution
        if (depth == N) {
            result++;
            return;
        }

        // isPromising
        for (int i = 0; i < N; i++) { // 현재 행에서 퀸을 놓을 수 있는 경우의 수
            if (isPromising(depth, i)) { // 퀸을 놓은 위치가 유망한지 확인
                map[depth][i] = 1; // 유망하면 퀸 배치
                backtrack(depth + 1); // 다음 열 퀸 배치
                map[depth][i] = 0;
            }
        }
    }

    private static boolean isPromising(int h, int w) {
        for (int i = 0; i < h; i++) {
            // 1. 같은 행에 있을 경우
            if (map[i][w] == 1)
                return false;

            // 2. 같은 대각선에 있을 경우
            // 왼쪽 위 대각선
            if (w - (h - i) >= 0) {
                if (map[i][w - (h - i)] == 1) {
                    return false;
                }
            }
            // 오른쪽 위 대각선
            if (w + (h - i) < N) {
                if (map[i][w + (h - i)] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}