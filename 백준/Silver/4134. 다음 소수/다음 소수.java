import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextLong();
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            long number = num[i];
            while (true) {
                if (isPrime(number)) {
                    sb.append(number + "\n");
                    break;
                }
                number++;
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(long num) {
        if(num < 2) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}