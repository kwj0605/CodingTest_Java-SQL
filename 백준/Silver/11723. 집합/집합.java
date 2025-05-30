import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열로 구현 -> 시간 초과
        // 해쉬셋으로 구현
        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            String next = sc.next();

            if (next.startsWith("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (next.startsWith("empty")) {
                for (int j = 1; j <= 20; j++) {
                    set.remove(j);
                }
            } else {
                int num = sc.nextInt();
                if (next.startsWith("a")) { // add
                    set.add(num);
                } else if (next.startsWith("r")) { // remove
                    set.remove(num);
                } else if (next.startsWith("c")) { // check
                    if (set.contains(num))
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                } else { // toggle
                    if (set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);
                }
            }
        }

        System.out.print(sb);
    }
}