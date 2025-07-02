import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		int delete = (int) Math.round(N * 0.15);

		int sum = 0;
		for (int i = delete; i < N - delete; i++) {			
			sum += list.get(i);
		}

		
		double avg = (double) sum / (N - (delete * 2));
		System.out.println(Math.round(avg));
	}
}