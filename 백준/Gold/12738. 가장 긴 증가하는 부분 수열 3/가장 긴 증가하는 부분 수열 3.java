import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. N 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 2. 수열 입력받기
        int[] nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        // 3. LIS 배열 생성
        List<Integer> lis = new ArrayList<>(); // 동적 배열을 위해 List생성

        for(int num : nums) {
            // 4. LIS 배열이 비어있거나 LIS배열의 마지막 수보다 수열의 수가 더 크면 LIS배열에 집어넣기
            if(lis.isEmpty() || lis.get(lis.size()-1) < num) {
                lis.add(num);
            }
            // 5. LIS 배열의 마지막 수보다 수열의 수가 더 작으면 앞에 알맞은 자리에 바꿔주기
            // 6. 알맞은 자리 -> 이분 탐색을 통해 숫자의 위치 확인(LIS배열은 순차대로 집어넣기 때문에 바로 이분 탐색 가능)
            else {
                int left = 0;
                int right = lis.size()-1;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    // lis(mid)값이 num보다 작으면 left = mid + 1
                    if(lis.get(mid) < num) {
                        left = mid + 1;
                    }
                    // lis(mid)값이 num보다 크면 right = mid - 1
                    else {
                        right = mid - 1;
                    }
                }
                // 적절한 위치에 num을 대체
                lis.set(left, num);
            }
        }
        // 7. LIS 배열의 크기 출력
        System.out.println(lis.size());
    }
}

