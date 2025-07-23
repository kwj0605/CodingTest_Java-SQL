import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		int increaseCount = 1;
		int decreaseCount = 1;
		for (int i = 1; i < N; i++) {
			// 증가하는 경우
			if (arr[i] >= arr[i - 1]) {
				increaseCount++;
			} else {
				increaseCount = 1;
			}

			// 감소하는 경우
			if (arr[i] <= arr[i - 1]) {
				decreaseCount++;
			} else {
				decreaseCount = 1;
			}

			max = Math.max(max, Math.max(increaseCount, decreaseCount));
		}

		System.out.println(max);
	}
}