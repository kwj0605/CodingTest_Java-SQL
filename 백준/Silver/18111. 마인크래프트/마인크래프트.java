import java.util.*;
import java.io.*;

class Main {

    static int[][] block;
    static int N;
    static int M;
    static int B;

    static int minTime;
    static int maxBlock;

    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        block = new int[N][M];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
                if (min > block[i][j])
                    min = block[i][j];
                if (max < block[i][j])
                    max = block[i][j];
            }
        }

        // sc.close();

        minTime = Integer.MAX_VALUE;
        maxBlock = Integer.MIN_VALUE;

        task();

        System.out.println(minTime + " " + maxBlock);

    }

    private static void task() { // 2초
        for (int i = min; i <= max; i++) {
            int time = 0;
            int bl = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < block[j][k]) {
                        time += 2 * (block[j][k] - i);
                        bl += block[j][k] - i;
                    }
                    if (i > block[j][k]) {
                        time += i - block[j][k];
                        bl -= i - block[j][k];
                    }
                }
            }
            if(bl < 0) return;

            if (time <= minTime) {
                minTime = time;
                maxBlock = i;
            }
        }
    }
}