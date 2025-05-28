import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder(); //출력 값 쌓아두고 한꺼번에 출력하기 위해
        
        int N = Integer.parseInt(st.nextToken()); //행렬 A의 N(행)
        int M = Integer.parseInt(st.nextToken()); //행렬 A의 M(열)

        int[][] A = new int[N][M]; //행렬 A

        for(int i = 0; i < N; i++){ //행렬 A 값 넣기
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0;  j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); //행렬 B의 M(행)
        int K = Integer.parseInt(st.nextToken()); //행렬 B의 K(열)

        int[][] B = new int[M][K]; //행렬 B

        for(int i = 0; i < M; i++){ //행렬 B 값 넣기
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0;  j < K; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행렬 곱셈 계산 반복문
        for(int i = 0; i < N; i++){
            for(int j =0; j < K; j++){
                int sum = 0;
                for(int k = 0; k < M; k++){
                    sum += A[i][k] * B[k][j];
                }
                // A의 i행의 j열 연산 값 출력 값에 저장
                sb.append(sum).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}