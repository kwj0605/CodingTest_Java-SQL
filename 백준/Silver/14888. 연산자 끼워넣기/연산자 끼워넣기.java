import java.util.*;

public class Main {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    static int N;
    static int[] nums;
    static int[] operator = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int index) {
        // isSolution() - 연산자를 모두 사용했을 때때
        if (index == N) { // 연산자의 개수는 N-1
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        // isPromising() - 연산자가 있으면 실행
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + nums[index], index + 1);
                        break;

                    case 1:
                        dfs(num - nums[index], index + 1);
                        break;

                    case 2:
                        dfs(num * nums[index], index + 1);
                        break;

                    case 3:
                        dfs(num / nums[index], index + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }
}