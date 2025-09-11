import java.util.*;

class Main {
    static int[] time;
    static int[] price;
    static int n;

    static int max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        time = new int[n];
        price = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }
        sc.close();

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int depth, int totalPrice) {
        // depth가 n이면 max비교하고 리턴
        if (depth == n) {
            max = Math.max(max, totalPrice);
            return;
        }

        // // left가 있으면 다음 넘김
        // if (left > 0) {
        // dfs(depth + 1, left - 1, totalPrice);
        // return;
        // }

        int nowTime = time[depth];
        int nowPrice = price[depth];
        // time+오늘 날짜 > n이면 다음 depth로 이동
        if (depth + nowTime > n) {
            dfs(depth + 1, totalPrice);
            return;
        }
        dfs(depth + nowTime, totalPrice + nowPrice); // 지금꺼를 해보고 다음꺼 해보기
        dfs(depth + 1, totalPrice); // 지금꺼를 패스하고 다음꺼 하기
    }
}

// 조건 1. time+ 오늘 날짜 <= n 이여야한다.
// 1<=n<=15 적은 숫자. -> 재귀로하면 2^15 ~= 64000쯤