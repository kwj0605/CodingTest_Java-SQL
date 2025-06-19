import java.util.*;

public class Main {
    static int N;
    static int S;
    static int[] nums;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();

        backtrack(0, 0);

        if(S==0) count--; // S가 0이면 모든 수를 안 더했을 때 num이 0인 경우가 있음음
        System.out.println(count);
    }

    private static void backtrack(int num, int index) {
        // isSoultion -> index가 N과 같고 num이 S와 같을 때
        if (index == N) {
            if (num == S) {
                count++;
            }
            return;
        }

        // 유망함수 - 남은 배열 더하기
        backtrack(num + nums[index], index + 1);
        backtrack(num, index + 1);
    }
}