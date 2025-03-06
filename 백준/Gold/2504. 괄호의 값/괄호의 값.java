import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int calculate(String gwalho) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < gwalho.length(); i++) {
            char ch = gwalho.charAt(i);

            if (ch == '(') {
                stack.push(-1); // '('를 -1로 저장
            } else if (ch == '[') {
                stack.push(-2); // '['를 -2로 저장
            } else {
                if (stack.isEmpty()) return 0; // 스택이 비었는데 닫는 괄호가 나오면 틀린 입력

                if (ch == ')') {
                    if (stack.peek() == -1) {
                        stack.pop();
                        stack.push(2); // () = 2
                    } else {
                        int sum = 0;
                        while (!stack.isEmpty() && stack.peek() > 0) {
                            sum += stack.pop(); // 숫자 합산
                        }
                        if (stack.isEmpty() || stack.peek() != -1) return 0; // 여는 괄호가 없으면 잘못된 괄호열
                        stack.pop(); // '(' 제거
                        stack.push(sum * 2); // (A) = A * 2
                    }
                } else if (ch == ']') {
                    if (stack.peek() == -2) {
                        stack.pop();
                        stack.push(3); // [] = 3
                    } else {
                        int sum = 0;
                        while (!stack.isEmpty() && stack.peek() > 0) {
                            sum += stack.pop(); // 숫자 합산
                        }
                        if (stack.isEmpty() || stack.peek() != -2) return 0; // 여는 괄호가 없으면 잘못된 괄호열
                        stack.pop(); // '[' 제거
                        stack.push(sum * 3); // [A] = A * 3
                    }
                }
            }
        }

        // 스택 안에 괄호(-1, -2)가 남아 있으면 올바르지 않은 괄호열
        int sum = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() < 0) return 0; // 스택에 괄호(-1, -2)가 남아 있으면 잘못된 괄호열
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String gwalho = sc.next();
        sc.close();

        System.out.println(calculate(gwalho));
    }
}