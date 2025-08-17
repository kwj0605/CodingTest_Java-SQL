import java.util.*;

class Main {
    static int cnt;
    static int result = -1;
    static int K;
    static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        int[] nums = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> list = new ArrayList<>();

        merge_sort(nums, 0, N - 1);

        System.out.println(result);
    }

    private static void merge_sort(int[] nums, int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(nums, p, q);
            merge_sort(nums, q + 1, r);
            merge(nums, p, q, r);
        }
    }

    private static void merge(int[] nums, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;

        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }
        while (i <= q) {
            tmp[t++] = nums[i++];
        }
        while (j <= r) {
            tmp[t++] = nums[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            cnt++;

            if (K == cnt) {
                result = tmp[t];
                break;
            }

            nums[i++] = tmp[t++];
        }
    }
}