class Solution {
    int count=0;
    int[] numbers; 
    int target;
    void dfs(int depth, int sum) {
        // 탈출 조건: 길이가 5면, 값이 3이면 count++
        if(depth == numbers.length) {
            if(sum == target) 
                count++;
            return;
        }
        // 재귀함수 길이+1, sum에 다음 numbers 더하기
        dfs(depth+1, sum+numbers[depth]);
        dfs(depth+1, sum-numbers[depth]);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.numbers=numbers;
        this.target=target;
        // dfs로 더하거나 빼서 5번 반복 해서 3이면 count++
        dfs(0, 0);
        // 결과값 return
        answer = count;
        return answer;
    }
}