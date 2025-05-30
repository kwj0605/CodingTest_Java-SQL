import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // list 사용
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        int idx = 0;
        while (list.size() > 1) {
            idx = (idx + (K - 1)) % list.size();
            sb.append(list.get(idx) + ", ");
            list.remove(idx);
        }

        sb.append(list.get(0) + ">");

        System.out.println(sb);
    }
}