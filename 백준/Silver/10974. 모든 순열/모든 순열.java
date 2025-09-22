import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] nums;
    static boolean[] isVisited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.close();

        nums = new int[n];
        isVisited = new boolean[n];
        result = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = nums[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
