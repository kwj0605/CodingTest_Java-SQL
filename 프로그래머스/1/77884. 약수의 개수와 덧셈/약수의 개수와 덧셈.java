class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int measure;

        for (int i = left; i <= right; i++) {
            measure =0;
            for (int j = 1; j <= i; j++) {
                if(i%j == 0) measure++;
            }
            
            if(measure % 2 == 0) {
                answer += i;
            }
            else answer -= i;
        }
        return answer;
    }
}