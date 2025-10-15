import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Student> photos = new ArrayList<>();
		Student[] students = new Student[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			// 사진 추가
			if (students[num] != null) { // 사진틀 존재
				// 이미 형성된 학생
				students[num].cnt++;
			} else { // 사진틀 존재 하지 않음
				// 사진틀 꽉 참

				// 정렬
				Collections.sort(photos);

				if (photos.size() == N) {
					// 사진 삭제
					Student del = photos.remove(N - 1);
					students[del.num] = null;
				}

				// 새로운 학생
				students[num] = new Student(num, 1, i);
				photos.add(students[num]);
			}
		}

		// photos 출력
		Collections.sort(photos, (o1, o2) -> o1.num - o2.num);
		for (Student s : photos) {
			System.out.print(s.num + " ");
		}
		
		br.close();
	}
}

class Student implements Comparable<Student> {
	int num;
	int cnt;
	int timeStamp;

	public Student(int num, int cnt, int timeStamp) {
		super();
		this.num = num;
		this.cnt = cnt;
		this.timeStamp = timeStamp;
	}

	// 추천횟수 내림차순, 시간 내림차순 정렬
	@Override
	public int compareTo(Student s2) {
		int resultCnt = s2.cnt - cnt;
		if (resultCnt == 0) {
			return s2.timeStamp - timeStamp;
		}
		return resultCnt;
	}

}