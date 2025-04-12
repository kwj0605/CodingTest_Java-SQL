import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. N과 M을 입력받는다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 나무의 길이를 입력받는다.
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }
        // 2. 절단기의 최소값 -> 가장 큰 나무의 길이 - M
        Arrays.sort(trees);
        int left = trees[N - 1] - M;
        // 3. 절단기의 최대값 -> 가장 큰 나무의 길이 - 0
        int right = trees[N - 1];
        // 4. 이진 탐색으로 구한다.
        long answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long added = 0;

            for (int i = 0; i < N; i++) {
                // mid보다 큰 나무의 자른 부분 added에 더하기
                if (mid < trees[i]) {
                    added += trees[i] - mid;
                }
            }

            // 5. 단, 자른 나무의 길이의 총합은 M보다 이상이다.
            if (added >= M) {
                // 6. 자른 나무 길이 중에 최소값을 구해야한다. -> 절단기 크기의 최대값
                // 절단기의 크기를 더 키울 수 있는 지 확인
                left = mid + 1;

                // 결과 값 저장
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

