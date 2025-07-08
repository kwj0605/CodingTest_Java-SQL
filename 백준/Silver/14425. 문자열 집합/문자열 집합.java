import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        HashSet<String> set = new HashSet();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            if (set.contains(sc.next())) {
                result++;
            }
        }

        sc.close();
        System.out.println(result);
    }
}