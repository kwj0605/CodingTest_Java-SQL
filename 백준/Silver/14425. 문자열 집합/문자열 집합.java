import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        HashMap<Integer, String> map = new HashMap();

        for (int i = 0; i < N; i++) {
            map.put(i, sc.next());
        }

        for (int i = 0; i < M; i++) {
            String arr = sc.next();
            for (int j = 0; j < N; j++) {
                if (map.get(j).equals(arr)) {
                    result++;
                }
            }
        }

        sc.close();
        System.out.println(result);
    }
}