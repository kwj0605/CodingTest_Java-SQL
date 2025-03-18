class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastPainted = 0; // 마지막으로 페인트칠한 위치

        for (int s : section) {
            // 현재 구역이 마지막으로 칠한 구역을 넘어가면 새로운 롤러 사용
            if (s > lastPainted) {
                answer++; // 새로운 페인트칠 횟수 증가
                lastPainted = s + m - 1; // 롤러의 끝 위치 갱신
            }
        }

        return answer;
    }
}