import java.util.*;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        // 포인트 번호를 좌표로 매핑 (1번부터 시작)
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // 시간별 좌표에 있는 로봇 수를 저장할 Map
        Map<Integer, Map<String, Integer>> timePositionMap = new HashMap<>();

        // 각 로봇의 경로에 따라 이동 시뮬레이션
        for (int[] route : routes) {
            int time = 0;

            // current를 복사해서 원본을 건드리지 않도록 함 (deep copy)
            int[] current = pointMap.get(route[0]);
            int[] position = new int[] { current[0], current[1] };

            // 시작 위치 기록
            recordPosition(timePositionMap, time, position);

            for (int i = 1; i < route.length; i++) {
                int[] target = pointMap.get(route[i]);

                // r 좌표 먼저 이동
                while (position[0] != target[0]) {
                    position[0] += (target[0] > position[0]) ? 1 : -1;
                    time++;
                    recordPosition(timePositionMap, time, position);
                }

                // c 좌표 이동
                while (position[1] != target[1]) {
                    position[1] += (target[1] > position[1]) ? 1 : -1;
                    time++;
                    recordPosition(timePositionMap, time, position);
                }
            }
        }

        // 시간별 좌표 확인하며 충돌 위험 상황 계산
        for (Map<String, Integer> positions : timePositionMap.values()) {
            for (int count : positions.values()) {
                if (count > 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 시간과 좌표 정보를 기록하는 함수
    private void recordPosition(Map<Integer, Map<String, Integer>> map, int time, int[] position) {
        map.putIfAbsent(time, new HashMap<>());
        String key = position[0] + "," + position[1];
        Map<String, Integer> positionsAtTime = map.get(time);
        positionsAtTime.put(key, positionsAtTime.getOrDefault(key, 0) + 1);
    }
}
