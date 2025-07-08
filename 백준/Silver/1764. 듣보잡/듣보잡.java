import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<String> list = new ArrayList<>();

        HashSet<String> set = new HashSet();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String arr = sc.next();
            if (set.contains(arr)) {
                list.add(arr);
            }
        }

        sc.close();
        System.out.println(list.size());
        Collections.sort(list);
        for (String arg : list) {
            System.out.println(arg);
        }
    }
}