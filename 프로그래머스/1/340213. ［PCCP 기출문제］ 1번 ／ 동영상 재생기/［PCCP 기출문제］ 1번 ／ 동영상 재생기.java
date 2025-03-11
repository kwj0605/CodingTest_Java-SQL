// 기능 
// 1. 10초전, 2. 10초 후, 3. 오프닝 건너뛰기
// 1) 10초 미만 -> 0초로
// 2) 남은시간 10초 미만 -> 끝으로
// 3) op_start <= 위치 <= op_end일 때 op끝으로

// 매개변수
// video_len : 동영상 길이
// pos : 기능 수행 전 재생 위치
// op_start : 오프닝 시작
// op_end : 오프닝 끝
// commands : 사용자 입력

// 출력 : 입력 후 동영상 위치 "mm:ss" 형식

// 0. for(command -> 끝) 
// 1. 비디오 길이에 있는 지 if(0<pos<video_len)
// 2. 오프닝 건너뛰기 우선 체크 if(op_st< pos <po_en)
// 3. 기능 실행
// 4. 반복문 끝나면 result 출력
class Solution {
    
    // 오프닝 건너뛰기
    int skipOp(int position, int opStart, int opEnd) {
        if(opStart<=position && position<opEnd) {
            return opEnd;
        }
        return position;
    }
    
    // 초로 변환
    int convertToSecond(String time) {
        String[] strTime = time.split(":");
        int mm = Integer.parseInt(strTime[0]);
        int ss = Integer.parseInt(strTime[1]);
        
        return mm*60+ss;
    }
    
    // 초에서 문자로 변환
    String convertToString(int position) {
        int mm = position/60;
        int ss = position%60;
        return String.format("%02d:%02d", mm, ss);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoLen = convertToSecond(video_len);
        int position = convertToSecond(pos);
        int opStart = convertToSecond(op_start);
        int opEnd = convertToSecond(op_end);
        
        for(String command : commands) {
            position = skipOp(position, opStart, opEnd);
            if(command.equals("prev")) {
                position = Math.max(position-10, 0);
            } else position = Math.min(position+10, videoLen);
        }
        position = skipOp(position, opStart, opEnd);
        
        answer = convertToString(position);
        
        return answer;
    }
}