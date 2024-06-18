class Solution {
    public int[] solution(int n, int m) {
        int[] answer;

        // 최대 공약수 
        int div = lcm(n, m);

        // 최소 공배수
        int mul = (n*m) / lcm(n, m);
        
        answer= new int[]{div, mul};
        
        return answer;
    }

    public int lcm(int n, int m) {
        int r=0;
        while (m != 0) {
            r = n%m;
            n = m;
            m = r;
        }
        return n;
    }
}