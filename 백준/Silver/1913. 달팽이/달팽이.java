import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int index = sc.nextInt();

        // 시작 좌표
        int x = N / 2;
        int y = N / 2;

        int[][] map = new int[N][N];

        int limit = 1;
        int value = 1;
        while (true) {
            for (int i = 0; i < limit; i++) {
                map[x--][y] = value++;
            }
            if (value > N * N)
                break;

            for (int i = 0; i < limit; i++) {
                map[x][y++] = value++;
            }
            limit++;
            for (int i = 0; i < limit; i++) {
                map[x++][y] = value++;
            }
            for (int i = 0; i < limit; i++) {
                map[x][y--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
		int tx=0, ty=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(index==map[i][j]) {
					ty=i+1;
					tx=j+1;
				}
				sb.append(map[i][j] +" ");
			}
			sb.append("\n");
		}
		sb.append(ty+" "+tx);
        System.out.println(sb.toString());
    }
}
// 규칙 1, 1, 2, 2, 3, 3, 4, 4 ~~ 증가
// 규칙 상 우 하 좌 순으로