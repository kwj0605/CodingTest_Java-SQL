class Solution {
    public int solution(int num) {
        int answer = 0;
        long collatz=num;
        
        for(int i=0; i<500; i++) {
            if(collatz==1) return i;
            if(collatz%2==0) collatz/=2;
            else collatz=collatz*3+1;
        }
        if(collatz != 1) answer = -1;
        
        return answer;
    }
}