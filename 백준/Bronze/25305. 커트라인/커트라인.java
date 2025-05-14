import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        // 내림차순을 comparator 사용하기 위해 객체로 생성
        Integer[] score = new Integer[N];

        for(int i=0; i<N; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score, (a, b) -> b - a);
        System.out.println(score[k-1]);
    }
}