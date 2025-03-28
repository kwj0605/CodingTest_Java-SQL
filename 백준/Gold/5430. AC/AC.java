import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            String func = sc.next(); // 수행할 함수
            int n = sc.nextInt(); // 배열 크기
            String arrS = sc.next(); // 배열 입력값 (예: "[1,2,3,4]")

            // 덱(Deque) 초기화
            Deque<Integer> deque = new LinkedList<>();
            if (n > 0) {
                // 배열 파싱 (대괄호 제거 후 "," 기준으로 분리)
                String[] elements = arrS.substring(1, arrS.length() - 1).split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean rev = false; // 뒤집기 상태 플래그
            boolean error = false; // 에러 플래그

            for (char command : func.toCharArray()) {
                if (command == 'R') {
                    rev = !rev; // 뒤집기 상태 변경
                } else { // 'D' 명령어
                    if (deque.isEmpty()) { // 배열이 비어있는 경우
                        error = true;
                        break;
                    }
                    if (rev) {
                        deque.removeLast(); // 뒤집힌 상태면 뒤에서 삭제
                    } else {
                        deque.removeFirst(); // 일반 상태면 앞에서 삭제
                    }
                }
            }

            // 출력
            if (error) {
                System.out.println("error");
            } else {
                // 결과 출력
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                while (!deque.isEmpty()) {
                    sb.append(rev ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }

                sb.append("]");
                System.out.println(sb);
            }
        }

        sc.close();
    }
}
