import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int h = park.length, w = park[0].length;
        int maxSize = 0;

        // 가장 큰 빈 공간(정사각형) 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i][j].equals("-1")) {
                    int k = 0;
                    while (i + k < h && j + k < w && !isExist(park, i, j, k)) {
                        k++;
                    }
                    maxSize = Math.max(maxSize, k); // 최대 정사각형 크기 갱신
                }
            }
        }

        // mats 배열을 내림차순 정렬 후, 가장 큰 값을 선택
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= maxSize) {
                return mats[i];
            }
        }

        return -1; // 아무 돗자리도 깔 수 없는 경우
    }

    boolean isExist(String[][] park, int i, int j, int k) {
        if (i + k >= park.length || j + k >= park[0].length) return true; // 범위 초과 방지
        for (int p = 0; p <= k; p++) {
            for (int q = 0; q <= k; q++) {
                if (!park[i + p][j + q].equals("-1")) {
                    return true; // 사람이 있는 경우
                }
            }
        }
        return false;
    }
}