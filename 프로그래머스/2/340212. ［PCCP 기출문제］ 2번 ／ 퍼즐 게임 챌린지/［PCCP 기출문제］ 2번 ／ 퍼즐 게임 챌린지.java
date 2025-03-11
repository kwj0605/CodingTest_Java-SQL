// 레벨이 난이도 이상 -> 현재 퍼즐 시간만
// 아니면 난이도-레벨 만큼 틀림 -> 틀릴 때마다 (현재+이전 퍼즐 시간) X 틀린 수 + 현재 퍼즐 시간
// limit안에 퍼즐을 다 푸는 최소값.

// 틀릴 때 함수 -> fail(현재, 이전, 틀린 횟수) return 총 시간
// 이진 탐색 알고리즘 while(minLevel<maxLevel), if(총 시간>limit) minLevel= level+1
import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        long totalTime=Long.MAX_VALUE; // 최소값을 구하기 위해 최대값 설정
        int level=0;
        int puzzle=0; // 현재 퍼즐의 순서
        
        // 이진 탐색으로 풀기 위해 min과 max 레벨 설정
        int minLevel = 1;
        int maxLevel = Arrays.stream(diffs).max().getAsInt();
        
        int time_prev, time_cur; // 이전, 현재 퍼즐 푸는데 걸리는 시간 
        while(minLevel<maxLevel) {
            // level 설정
            level = (minLevel + maxLevel)/2;
            
            totalTime=0; // 0으로 초기화
            // 1번째 퍼즐 시간 추가
            totalTime+=times[0];
            for(int i=1; i<diffs.length; i++) {
                time_prev=times[i-1];
                time_cur=times[i];
                
                if(level>=diffs[i]) {
                    totalTime+=time_cur;
                } else {
                    totalTime+=(time_prev+time_cur)*(diffs[i]-level)+time_cur; 
                }
            }
            
            if(totalTime>limit) {
                minLevel=level+1;
            } else {
                maxLevel=level;
            }
        }
        answer = maxLevel;
        return answer;
    }
    
}