import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();

        int k = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Queue<Integer> op = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            op.offer(sc.nextInt());
        }
        sc.close();

        int[] dice = { 0, 0, 0, 0, 0, 0 }; // 위, 아래, 동, 서, 남, 북

        while (!op.isEmpty()) {
            int nop = op.poll();

            // 1 = 동, 2 = 서, 3 = 북, 4 = 남
            if (nop == 1) {
                if (0 <= y + 1 && y + 1 < m)
                    y++;
                else
                    continue;

                int prev = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = prev;
            }
            if (nop == 2) {
                if (0 <= y - 1 && y - 1 < m)
                    y--;
                else
                    continue;

                int prev = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = prev;
            }
            if (nop == 3) {
                if (0 <= x - 1 && x - 1 < n)
                    x--;
                else
                    continue;

                int prev = dice[5];
                dice[5] = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = prev;
            }
            if (nop == 4) {
                if (0 <= x + 1 && x + 1 < n)
                    x++;
                else
                    continue;
                    
                int prev = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = prev;
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[0]);
        }
    }
}
