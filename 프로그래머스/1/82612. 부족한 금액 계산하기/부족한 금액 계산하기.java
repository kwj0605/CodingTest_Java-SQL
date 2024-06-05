class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long sumPrice = 0;
        for (int i = 0; i < count; i++) {
            sumPrice += price*(i+1);
        }

        if (sumPrice > money) {
            answer = sumPrice - money;
        }
        else {
            answer = 0;
        }

        return answer;
    }
}
