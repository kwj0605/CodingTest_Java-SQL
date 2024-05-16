class Solution {
    public int solution(int num) {
        int answer = 0;
        if(num == 1) return 0;
        while (num != 1){
            if (num % 2 == 0) {
                num /= 2;
            } else if (answer >=450) {
                return -1;
            } else {
                num = num*3+1;
            }
            answer++;
        }

        return answer;
    }
}