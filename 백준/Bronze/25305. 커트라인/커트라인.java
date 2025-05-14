import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] score = new int[N];

        for(int i=0; i<N; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score);

        // 뒤집기
        for(int i=0; i<N/2; i++) {
            int temp = score[i];
            score[i] = score[N-1-i];
            score[N-1-i] = temp;
        }
        
        System.out.println(score[k-1]);
    }
}