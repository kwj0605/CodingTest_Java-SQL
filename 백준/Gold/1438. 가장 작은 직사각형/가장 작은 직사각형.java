import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.x, other.x);
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        sc.close();

        Arrays.sort(points); // x값 순으로 오름차순 정렬

        long minArea = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int width = points[j].x - points[i].x;

                List<Integer> yCoords = new ArrayList<>();

                for (int k = 0; k < n; k++) { // i번째와 j번째 x값 사이에 있는 좌표의 y값을 구함
                    if (points[k].x >= points[i].x && points[k].x <= points[j].x) {
                        yCoords.add(points[k].y);
                    }
                }

                if (yCoords.size() < n / 2) // y좌표가 n/2보다 적으면 좌표갯수가 부족하므로 다시
                    continue;

                Collections.sort(yCoords); // y값 오름차순 정렬

                for (int k = 0; k <= yCoords.size() - n / 2; k++) { // y좌표에서 가장 큰 것과 작은 것을 구하면서 height를 구함
                    int height = yCoords.get(k + n / 2 - 1) - yCoords.get(k);
                    long area = (long) (width + 2) * (height + 2);
                    minArea = Math.min(minArea, area); // 최소 넓이를 구함
                }
            }
        }
        System.out.println(minArea);
    }
}