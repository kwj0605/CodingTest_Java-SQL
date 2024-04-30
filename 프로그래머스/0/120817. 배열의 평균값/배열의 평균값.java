class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum=0;
        int count=0;
        for(int i:numbers) {
            sum+=i;
            count++;
        }
        
        answer = sum/count;
        return answer;
    }
}