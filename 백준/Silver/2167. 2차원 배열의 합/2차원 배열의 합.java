import java.io.*;
import java.util.*;
 
 
public class Main {
	
	public static int N, M;
	public static int[][] arr;
	public static int[][] prefixSum;
	public static int K, i,j,x,y;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[N][M];
    	prefixSum = new int[N+1][M+1];
    	
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=M;j++) {
    			prefixSum[i][j] = arr[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	K = Integer.parseInt(st.nextToken());
    	
    	for(int v=0;v<K;v++) {
    		st = new StringTokenizer(br.readLine());
    		int i = Integer.parseInt(st.nextToken());
    		int j = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		int result = prefixSum[x][y] - prefixSum[x][j-1] - prefixSum[i-1][y] + prefixSum[i-1][j-1];
    		System.out.println(result);
    	}
    }
}