import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static List<Node> house = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();
    static boolean[] isVisited; // 치킨집의 방문 여부
    static int result = Integer.MAX_VALUE; // 도시의 치킨 거리의 최솟값
    static void backtracking(int count, int index)  {
        if(count == m) { // 방문한 치킨집의 갯수가 m개이면
            int sum = 0; // 도시의 치킨 거리
            for(int i=0; i<house.size(); i++) {
                int minDistance=Integer.MAX_VALUE; // 한 집에서 방문한 치킨 거리의 최솟값
                for(int j=0; j<chicken.size(); j++) { // 모든 집에 따른 방문한 치킨집의 거리 구하기
                    if(isVisited[j]) { // 조건 : 방문한 집일 경우
                        // 집에서 치킨집의 거리 : x와 y의 차의 절대값의 합
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        minDistance = Math.min(minDistance, distance); // 연산1. 각 집에 따른 치킨거리 최솟값
                    }
                }
                sum += minDistance; // 연산2. sum(도시의 치킨 거리) : 모든 집에서 치킨 거리의 최솟값의 합
            }

            // 연산3. m개 만큼의 치킨집을 방문했을 때 도시의 치킨 거리의 최솟값
            result = Math.min(result, sum);
            return;
        }

        // 아직 방문하지 않은 치킨집이 있으면 방문하고 count+1
        // i를 index부터 시작해서 방문한 치킨집이 중복되지 않게 한다.
        for(int i=index; i<chicken.size(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                backtracking(count+1, i+1);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // map 생성
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 집과 치킨집의 좌표 List
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    house.add(new Node(i, j));
                }
                else if(map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        // 방문할 치킨집
        isVisited = new boolean[chicken.size()];

        // 백트래킹 실행
        backtracking(0, 0);

        System.out.println(result);
    }
}
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// 치킨거리 : 집과 가장 가까운 치킨집 거리 -> bfs
// 도시 치킨 거리 : 모든 치킨 거리 합
// 0: 길, 1: 집, 2: 치킨집
// -------------------- 틀린 풀이
// 1. 모든 집을 탐색
// 2. 치킨집 거리 찾기
// 3. 가장 잘 팔리는 치킨집 m개만 남기기
// 4. 도시 치킨 거리 찾기

// -------------------- 2번째 풀이
// 1. 집과 치킨집의 좌표를 각각 list 저장
// 2. 치킨집이 open한 개수가 M과 같다면, 모든 집에 대해 M개의 치킨 집 중 최단 거리를 계산
// 3. 탐색을 시작하는 지점이 치킨집 list의 사이즈가 벗어나게 되면 탐색 종료
// 출력: 도시 치킨 거리 최소값

