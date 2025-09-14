import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> nums = new ArrayList<>();
        
        for(int[] ball : balls) {
            int targetX = ball[0];
            int targetY = ball[1];
            
            int h = 0;
            int w = 0;
            int min = Integer.MAX_VALUE;
            
            if(!(targetX == startX && targetY > startY)) { // x가 같고, target이 시작점보다 위에 있으면 안됨.
                // 위로 
                h = (n - startY) + (n - targetY);
                w = targetX - startX;

                min = Math.min(min, (h*h + w*w));
            }

            if(!(targetX == startX && targetY < startY)) {
                // 아래로
                h = startY + targetY;
                w = targetX - startX;

                min = Math.min(min, (h*h + w*w));
            }
            if(!(targetY == startY && targetX < startX)) {
                // 좌로
                w = startX + targetX;
                h = targetY - startY;
                
                min = Math.min(min, (h*h + w*w));
            }

            if(!(targetY == startY && targetX > startX)) {
                // 우로
                w = (m - startX) + (m - targetX);
                h = targetY - startY; // 어차피 제곱하면 +됨

                min = Math.min(min, (h*h + w*w));
            }
            
            
            
            nums.add(min);
        }
        
        return nums.stream()
            .mapToInt(Integer :: intValue)
            .toArray();
    }
}

// 일열에 있으면 안됨. x가 일치하면 y반전으로만 / y가 일치하면 x반전으로만
// 상하좌우 틀 밖으로 넘겨서 대각선의 길이 구하기 