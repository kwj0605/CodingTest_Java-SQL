import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        sc.close();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        sb.append("<");

        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if (q.isEmpty()) {
                break;
            }
            sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}