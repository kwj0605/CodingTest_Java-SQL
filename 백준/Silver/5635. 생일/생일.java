import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Person> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			list.add(new Person(input));
		}

		Collections.sort(list);

		System.out.println(list.get(N - 1));
		System.out.println(list.get(0));

	}

	static class Person implements Comparable<Person> {
		String name;
		int dd;
		int mm;
		int yy;

		Person(String[] input) {
			this.name = input[0];
			dd = Integer.parseInt(input[1]);
			mm = Integer.parseInt(input[2]);
			yy = Integer.parseInt(input[3]);
		}

		@Override
		public int compareTo(Person o) {
			if (this.yy == o.yy) {
				if (this.mm == o.mm) {
					return Integer.compare(this.dd, o.dd);
				}

				return Integer.compare(this.mm, o.mm);
			}

			return Integer.compare(this.yy, o.yy);
		}

		@Override
		public String toString() {
			return name;
		}
	}

}