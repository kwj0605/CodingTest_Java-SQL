import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. N 입력
        int N = sc.nextInt();
        sc.close();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int cnt = 0;
        while (q.size() != 1) {
            if (cnt % 2 == 0) {
                // 2 - 1. 카드를 버리고 출력
                System.out.print(q.poll() + " ");
            } else {
                // 2 - 2. 카드를 아래로 내림
                q.offer(q.poll());
            }
            cnt++;

            // 3. 카드가 한 장 남으면 출력하고 스탑
        }
        System.out.println(q.poll());

        // 자료구조 : queue 사용용
    }
}