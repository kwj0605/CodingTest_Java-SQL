import java.util.*;

public class Main {
    static List<String> p = new ArrayList<>(); // 수행할 함수
    static List<Deque<Integer>> num = new ArrayList<>(); // 정수형 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            String func = sc.next();
            int n = sc.nextInt();
            String arrS = sc.next(); // [x1, ..., xn] 형태
            Deque<Integer> nums = new LinkedList<>();

            if (n != 0) {
                String[] elements = arrS.substring(1, arrS.length()-1).split(",");
                for(String element : elements) {
                    nums.add(Integer.parseInt(element));
                }
            }
            // List에 넣기
            p.add(func);
            num.add(nums);
        }
        sc.close();

        for(int i=0; i<T; i++) {
            String function = p.get(i);
            Deque<Integer> nums = num.get(i);
            boolean rev = false;
            boolean error = false;
            for(int j=0; j<function.length(); j++) {
                if(function.charAt(j)=='R') { // 명령어 R
                    rev = !rev;
                } else { // 명령어 D
                    if(nums.isEmpty()) {
                        error = true; // error 로 error 출력
                        break; // ** -1이 들어있는 상태로 또 D를 수행하면 -1이 사라짐
                    } else{
                        if(rev) {
                            nums.removeLast();
                        } else {
                            nums.removeFirst();
                        }
                    }
                }
            }

            // 출력
            if(error) {
                System.out.println("error");
            } else{
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!nums.isEmpty()) {
                    sb.append(rev ? nums.removeLast() : nums.removeFirst());
                    if(!nums.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}

// 1. reverse는 Collections.reverse()로 구현하기 위해 List
// 2. drop은 앞의 수를 뺄 수 있는 queue로 구현
// 시간 초과 -> dequeue를 사용해서 reverse하고 drop이면 뒤에서 빼고 아니면 앞에서 빼고 | 직접 reverse 연산을 하지 않음.

