import java.util.*;

public class Main {
    static int[] arr;
    static final int LOTTO_NUM = 6;
    static StringBuilder sb;
    static int[] lotto = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        while (true) {
            int N = sc.nextInt();
            if (N == 0)
                break;

            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            backtrack(0, 0);
            sb.append("\n");
        }
        sc.close();

        System.out.println(sb);
    }

    private static void backtrack(int depth, int index) {
        if (depth == 6) {
            for (int i = 0; i < LOTTO_NUM; i++) {
                sb.append(lotto[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            lotto[depth] = arr[i];
            backtrack(depth + 1, i + 1);
        }
    }
}