import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] used;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N + 1];
        result = new int[M + 1];

        backtrack(0, 1);
    }

    public static void backtrack(int depth, int index) {
        // M과 같으면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 유망한지 확인(사용되지 X)
        for (int i = index; i <= N; i++) {
            result[depth] = i;

            backtrack(depth + 1, i);
        }
    }
}