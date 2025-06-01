import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int N = sc.nextInt();

        // 10의 제곱수 부터 더해지는 자릿수가 증가함
        // 2. 1~N까지 자릿수 더하기
        int result = 0;
        int num = 1; // 더해지는 자릿수
        int criteria = 10; // 나눌 수
        for (int i = 1; i <= N; i++) {
            if (i % criteria == 0) {
                num++;
                criteria *= 10;
            }
            result += num;
        }

        System.out.println(result);
    }
}

// 규칙
// 1~9 1자리수 : 9
// 10~99 2자리수 : 90
// 100~999 3자리수 : 900
// 1000~9999 4자리수 : 9000
// 10000~99999 5자리수 : 90000
// 100000~999999 6자리수 : 900000