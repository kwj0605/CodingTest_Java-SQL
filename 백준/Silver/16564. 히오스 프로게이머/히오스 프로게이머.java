import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] levels = new int[N];
        for(int i=0; i<N; i++) {
            levels[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(levels);

        int left = levels[0];
        int right = levels[0] + K;
        int answer = 0;

        while(left<=right) {
            int mid = (left+right)/2;
            long added = 0;

            for(int i=0; i<N; i++) {
                if(levels[i]<mid) added += mid-levels[i];
            }

            if(added>K) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}

