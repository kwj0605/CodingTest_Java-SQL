import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            sb.append(map.getOrDefault(sc.nextInt(), 0));
            sb.append(" ");
        }

        sc.close();
        System.out.println(sb);
    }
}