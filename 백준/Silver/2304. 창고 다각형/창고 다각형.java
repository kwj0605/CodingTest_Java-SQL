import java.util.*;

class Main {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node[] nodes = new Node[n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            nodes[i] = new Node(x, y);
            maxHeight = Math.max(maxHeight, y);
        }
        sc.close();

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });

        // 최대 높이 구간 찾기 (여러개가 있을 수 있음) ex) (5, 5), (7, 5), (10, 5) 등
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i].y == maxHeight) {
                leftMax = nodes[i].x;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nodes[i].y == maxHeight) {
                rightMax = nodes[i].x;
                break;
            }
        }

        int fx = nodes[0].x;
        int fy = nodes[0].y;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i].y > fy) {
                sum += (nodes[i].x - fx) * fy;
                fx = nodes[i].x;
                fy = nodes[i].y;
            }

            if (fx == leftMax && fy == maxHeight) { // 처음부터 가장 긴 y를 가진 곳까지 계산
                break;
            }
        }

        fx = nodes[n - 1].x;
        fy = nodes[n - 1].y;
        for (int i = n - 1; i >= 0; i--) {
            if (nodes[i].y > fy) {
                sum += (fx - nodes[i].x) * fy;
                fx = nodes[i].x;
                fy = nodes[i].y;
            }

            if (fx == rightMax && fy == maxHeight) { // 가장끝에서 가장 긴 y를 가진 곳까지 계산
                break;
            }
        }
        sum += (rightMax - leftMax + 1) * maxHeight; // 가장 긴 y의 면적 더하기

        System.out.println(sum);
    }

}