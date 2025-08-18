class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        int start = toSec(h1, m1, s1);
        int end = toSec(h2, m2, s2);
        
        answer = end*59/3600 + end*719/43200 - start*59/3600 - start*719/43200;
        
        if(start >= 43200) { // 시작시간이 12시가 넘어가면 1번 울린다.
            answer++;
        }
        if(end >= 43200) { // 시, 분, 초침이 모두 같으니까 1번 빼줘야한다.
            answer--;
        }
        if(start%3600 == 0) { // 시작때 딱 정각이면 1번울려야한다.
            answer++;
        }
        
        return answer;
    }
    
    private int toSec(int h, int m, int s) {
        return h*3600 + m*60 + s;
    }
}