import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] used;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N + 1];
        result = new int[M + 1];

        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        // M과 같으면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[depth] = i;

            dfs(depth + 1);
        }
    }
}