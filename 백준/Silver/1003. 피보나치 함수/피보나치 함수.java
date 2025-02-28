import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 개수
        int[][] dp = new int[41][2]; // 0과 1의 호출 횟수를 저장할 배열

        // 초기값 설정
        dp[0][0] = 1; // fibonacci(0) 호출 시 0이 1번 출력됨
        dp[0][1] = 0; // fibonacci(0) 호출 시 1이 0번 출력됨
        dp[1][0] = 0; // fibonacci(1) 호출 시 0이 0번 출력됨
        dp[1][1] = 1; // fibonacci(1) 호출 시 1이 1번 출력됨

        // DP 테이블 채우기 
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 입력값에 대한 결과 출력
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }

        scanner.close();
    }
}
