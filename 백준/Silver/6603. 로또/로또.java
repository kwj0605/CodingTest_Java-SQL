import java.io.*;
import java.util.*;
 
public class Main {
	
	public static int k, S;
	public static int answer = 0;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] answerArr;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	answerArr = new int[6];
    	while(true) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		k = Integer.parseInt(st.nextToken());
    		if(k == 0) 
    			break;
    		
    		arr = new int[k];
    		visited = new boolean[k];
    		for(int i=0;i<k;i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		simulate(0, 0);
    		System.out.println();
    	}
    }
    
    public static void simulate(int idx, int level) {
    	if(level == 6) {
    		for(int i=0;i<6;i++) {
    			System.out.print(answerArr[i]+" ");
    		}
    		System.out.println();
    		return ;
    	}
    	for(int i=idx;i<k;i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			answerArr[level] = arr[i];
    			simulate(i+1, level + 1);
    			visited[i] = false;
    		}
    	}
    }
}