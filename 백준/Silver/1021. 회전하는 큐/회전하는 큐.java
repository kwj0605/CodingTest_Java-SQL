import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); 
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count = 0; // 2번, 3번 연산 횟수 누적 변수

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            
            // 현재 큐에서 뽑아야 할 원소의 위치 찾기
            int targetIdx = deque.indexOf(target);

            // 왼쪽 이동(2번)과 오른쪽 이동(3번) 중 최적 선택
            int leftMove = targetIdx;                
            int rightMove = deque.size() - targetIdx; 

            if (leftMove <= rightMove) { // 왼쪽 이동이 더 빠를 경우
                for (int j = 0; j < leftMove; j++) {
                    deque.addLast(deque.pollFirst()); 
                }
                count += leftMove;
            } else { // 오른쪽 이동이 더 빠를 경우
                for (int j = 0; j < rightMove; j++) {
                    deque.addFirst(deque.pollLast()); 
                }
                count += rightMove;
            }

            deque.pollFirst();
        }

        System.out.println(count);
        sc.close();
    }
}
