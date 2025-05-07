import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();  // 명령 개수
        Deque<Integer> deque = new LinkedList<>();

        // 줄바꿈 문자 처리
        sc.nextLine(); 

        for (int i = 0; i < num; i++) {
            String command = sc.nextLine();  // 한 줄 전체를 읽음

            if (command.startsWith("push_front")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(value);

            } else if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(value);

            } else if (command.equals("pop_front")) {
                System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());

            } else if (command.equals("pop_back")) {
                System.out.println(deque.isEmpty() ? -1 : deque.pollLast());

            } else if (command.equals("size")) {
                System.out.println(deque.size());

            } else if (command.equals("empty")) {
                System.out.println(deque.isEmpty() ? 1 : 0);

            } else if (command.equals("front")) {
                System.out.println(deque.isEmpty() ? -1 : deque.getFirst());

            } else if (command.equals("back")) {
                System.out.println(deque.isEmpty() ? -1 : deque.getLast());
            }
        }

        sc.close();
    }
}
