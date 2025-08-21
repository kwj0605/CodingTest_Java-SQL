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

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(points);

        long minArea = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // x좌표 경계 (points[i].x, points[j].x)
                int width = points[j].x - points[i].x;

                // y좌표를 담을 리스트
                List<Integer> yCoords = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    // x좌표 경계 안에 있는 점들의 y좌표만 모음
                    if (points[k].x >= points[i].x && points[k].x <= points[j].x) {
                        yCoords.add(points[k].y);
                    }
                }
                Collections.sort(yCoords);

                // 투 포인터로 y좌표 경계 찾기
                if (yCoords.size() < n / 2) continue;

                for (int k = 0; k <= yCoords.size() - n / 2; k++) {
                    int height = yCoords.get(k + n / 2 - 1) - yCoords.get(k);
                    long area = (long) (width + 2) * (height + 2); // 직사각형 내부 조건
                    minArea = Math.min(minArea, area);
                }
            }
        }
        System.out.println(minArea);
    }
}