import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int n = 0; // 몇 번째 대각선인지
        int sum = 0; // 현재 대각선까지의 총 개수

        // X가 포함된 대각선 찾기
        while (sum < X) {
            n++;
            sum += n;
        }

        // X번째가 대각선에서 몇 번째인지
        int prevSum = sum - n; // 이전 대각선까지의 합
        int index = X - prevSum; // 현재 대각선에서 몇 번째인지

        int numerator, denominator;

        if (n % 2 == 1) { // 홀수 번째 대각선 (↗ 방향)
            numerator = n - index + 1;
            denominator = index;
        } else { // 짝수 번째 대각선 (↙ 방향)
            numerator = index;
            denominator = n - index + 1;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
