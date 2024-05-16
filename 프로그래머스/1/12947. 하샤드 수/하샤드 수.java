class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (int)str.charAt(i)-48;
        }

        if (x%sum != 0) {
            answer = false;
        }

        return answer;
    }
}


// 각 자릿수 합 더하기
// 나머지 ==0 -> true