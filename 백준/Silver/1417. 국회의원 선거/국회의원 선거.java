import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int me = sc.nextInt(); //나 == 다솜
		Integer arr[] = new Integer[N-1]; //내림차순 정렬을 위해 박싱
		int count = 0; //매수해야 하는 사람 수
		for(int i = 0; i < arr.length; ++i) arr[i] = sc.nextInt();
		while(true)
		{
			Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
			if(N == 1 || arr[0] < me) break; //N이 0이거나 배열의 가장 큰 수가 나보다 작으면 탈출
			else
			{
				++me;
				--arr[0];
				++count;
			}
		}
		System.out.print(count);
	}
}