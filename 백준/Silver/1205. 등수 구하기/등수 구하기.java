import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int newScore = sc.nextInt();
        int p = sc.nextInt();

        Integer[] scores = new Integer[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // 1. 내림차순 정렬
        Arrays.sort(scores, Collections.reverseOrder());

        // 에러부터 처리
        if (n == p && newScore <= scores[n-1]) {
            System.out.println(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < n; i++) {
                if (newScore < scores[i]) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}