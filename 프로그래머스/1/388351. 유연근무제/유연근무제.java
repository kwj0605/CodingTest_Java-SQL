 // 평일 출근 근무 찾기 -> startday 이용
// 평일 근무 안 늦었는 지
// 모두 안늦었으면 count+1
class Solution {    
    int scheduleTime(int schedules) {
        schedules+=10;
        // 60분 넘어가면 시간 1더하기
        if(schedules%100>=60) schedules+=40;
        
        return schedules;
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // 직원 수
        int n = schedules.length;
        
        // 상을 줄 직원 수
        int answer = n;
        
        // n명의 직원 반복
        for(int i=0; i<n; i++) {
            // 시작일 복사본
            int copyStartday = startday;
            
            // 시간을 10분 더하기
            int scheduleTime = scheduleTime(schedules[i]);
            
            for(int j=0; j<7; j++) {
                // 주말은 건너 뛴다.
                if(copyStartday >= 6) {
                    copyStartday++;
                    if(copyStartday > 7) copyStartday=1;
                    System.out.println("요일 : "+ copyStartday);
                    continue;
                }
                
                // 출근한 시간이 정한 시간보다 늦으면 상주는 직원 감소
                if(scheduleTime < timelogs[i][j]) {
                    answer--;
                    break;
                }

                copyStartday++;
            }
        }
        
        return answer;
    }
}

// schedules : n명의 직원이 설정한 출근 희망 시각
// timelogs : 직원들이 일주일 동안 출근한 시각
// startday : 이벤트 시작 요일(월~일)

// 주말 출근은 출근 시각에 영향 X

// 제한 사항
// 1<=n<=1000
// 1<=startday<=7

// timlogs[직원수 n][몇 일 7]

// 불변수
// 시간 = 60
// 일주일 = 7
// 시간 합산 수 = 100
// 출근 인정 +시간 = 10