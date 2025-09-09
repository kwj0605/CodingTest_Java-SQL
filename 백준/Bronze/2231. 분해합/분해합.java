import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        int result = 0;
        for (int i = 1; i < n; i++) {
            int num = i;
            int clone = i;
            while (clone > 0) {
                num += clone % 10;
                clone /= 10;
            }
            if (num == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}