import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long[] jusawi = new long[6];
        for (int i = 0; i < 6; i++) {
            jusawi[i] = sc.nextInt();
        }
        sc.close();

        if (n == 1) { // n이 1이면 작은 수 5개의 합
            int answer = 0;
            long max = 0;
            for (int i = 0; i < 6; i++) {
                answer += jusawi[i];
                max = Math.max(max, jusawi[i]);
            }
            System.out.println(answer-max);
            return;
        }

        long a = (n - 2) * (n - 2) * 5 + (n - 2) * 4;
        long b = (n - 2) * 8 + 4;
        long c = 4;

        long aa = Long.MAX_VALUE, bb = Long.MAX_VALUE, cc = 0; // 주사위 눈의 최대수는 50
        // 1면
        for (int i = 0; i < 6; i++) {
            aa = Math.min(aa, jusawi[i]);
        }

        // 2면
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i + j != 5 && i != j) {
                    bb = Math.min(bb, jusawi[i] + jusawi[j]);
                }
            }
        }

        // 3면
        for (int i = 0; i < 3; i++) {
            cc += Math.min(jusawi[i], jusawi[5 - i]);
        }

        long min = a * aa + b * bb + c * cc;
        System.out.println(min);
    }
}
