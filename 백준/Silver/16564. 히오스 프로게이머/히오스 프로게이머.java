import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. N과 K를 입력받는다
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 2. 팀원의 레벨을 입력받는다
        int[] teamlv = new int[N];
        for (int i = 0; i < N; i++) {
            teamlv[i] = sc.nextInt();
        }

        // 이분탐색을 위해 정렬
        Arrays.sort(teamlv);

        // 3. 팀 목표레벨의 최소값 : 가장 작은 팀 레벨 + 0;
        int left = teamlv[0];
        // 팀 목표레벨의 최대값 : 가장 작은 팀 레벨 + K;
        int right = teamlv[0] + K;
        long answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long added = 0;
            for (int i = 0; i < N; i++) {
                // mid가 teamlv보다 크면 teamlv을 더하기
                if (mid > teamlv[i]) {
                    added += mid - teamlv[i];
                }
            }
            // 더한 레벨은 K보다 작거나 같아야함.-> 더 높은 레벨도 가능한지 확인
            if (added <= K) {
                left = mid + 1;
                // 해를 구할 때 마다 정답을 저장해둠.
                answer = Math.max(mid, answer);
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }
}

