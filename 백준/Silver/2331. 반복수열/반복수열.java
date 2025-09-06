import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();  // 첫 번째 정수
        int P = sc.nextInt();  // 두 번째 정수

        ArrayList<Integer> num_arr = new ArrayList<>();
        num_arr.add(A);

        while (true) {
            int new_num = nextNum(A, P);

            if (num_arr.contains(new_num)) {
                System.out.println(num_arr.indexOf(new_num));  // 반복 수열 시작 위치 출력
                break;
            }

            num_arr.add(new_num);
            A = new_num;
        }

        sc.close();
    }

    // 수열의 규칙에 따라 숫자를 계산하는 함수
    public static int nextNum(int A, int P) {
        int new_num = 0;
        while (A != 0) {
            new_num += Math.pow(A % 10, (double) P);  // 각 자리 숫자의 P제곱을 더함
            A /= 10;
        }
        return new_num;
    }
}