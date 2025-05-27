import java.util.*;

public class Main {
    static int[][] map = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 값 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 2. 문자열로 받아서 split 후 숫자 변환
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        // 2-2. map 만들기
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] sp = arr[i].split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(sp[j]);
            }
        }
        sc.close();

        // 3. N과 M중 작은 숫자 = len
        // 첫번째부터 [x+len-1][y+len-1] 이 밖을 나가지 않는 선에서 탐색
        // [x][y], [x+len-1][y], [x][y+len-1], [x+len-1][y+len-1] 이 같아야함
        int len = Math.min(N, M);
        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    int target = map[i][j];

                    if (target == map[i + len - 1][j]
                            && target == map[i][j + len - 1]
                            && target == map[i + len - 1][j + len - 1]) {
                        System.out.println(len * len);
                        return;
                    }
                }
            }

            len--;
        }

        // 4. 결과값은 len*len
        System.out.println(len * len);
    }
}