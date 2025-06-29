import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Query> querys = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			querys.add(new Query(answer, strike, ball));
		}

		int result = 0;
		for (int num = 123; num < 988; num++) {
			if (!isValid(num)) {
				continue;
			}

			int correctCount = 0;
			for (Query query : querys) {
				int strikeCount = 0;
				int ballCount = 0;
				String numStr = Integer.toString(query.answer);
				String targetStr = Integer.toString(num);

				// 스트라이크 검사
				for (int i = 0; i < 3; i++) {
					if (numStr.charAt(i) == targetStr.charAt(i)) {
						strikeCount++;
					}
				}

				if (strikeCount != query.strike) {
					break;
				}

				// 볼 검사
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (numStr.charAt(i) == targetStr.charAt(j) && (i != j)) {
							ballCount++;
						}
					}
				}

				if (ballCount != query.ball) {
					break;
				}

				if (strikeCount == query.strike && ballCount == query.ball) {
					correctCount++;
				}
			}

			if (correctCount == N) {
				result++;
			}
		}

		System.out.println(result);
	}

	static boolean isValid(int num) {
		int first = num / 100;
		int second = num % 100 / 10;
		int third = num % 10;

		if (second == 0 || third == 0) {
			return false;
		}

		if (first == second || second == third || first == third) {
			return false;
		}

		return true;
	}

	static class Query {
		int answer;
		int strike;
		int ball;

		Query(int answer, int strike, int ball) {
			this.answer = answer;
			this.strike = strike;
			this.ball = ball;
		}
	}
}