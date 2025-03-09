import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        int[][] people = new int[N][2];  
        
        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt(); 
            people[i][1] = sc.nextInt(); 
        }
        
        // 등수 계산
        for (int i = 0; i < N; i++) {
            int rank = 1;  // 기본 등수는 1등
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 자기 자신 비교 X
                
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank++;  // 자신보다 큰 덩치의 사람 수만큼 등수 증가
                }
            }
            System.out.print(rank + " "); // 등수 출력
        }
        
        sc.close();
    }
}
