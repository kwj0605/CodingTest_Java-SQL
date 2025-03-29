class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int N = bandage[0]; // 시전 시간
        int n = 0; // 지속 시간
        int a = 0; // 공격 배열 번호
        
        System.out.println(attacks[attacks.length-1][0]);
        
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            if(i == attacks[a][0]) { // 공격받을 경우
                answer -= attacks[a][1];

                if(answer <= 0) return -1; // 죽을 경우

                n = 0;
                a++;
            } else { // 공격 안받을 경우
                if(n != N) { // 일반 힐
                    if(answer+bandage[1] < health) { 
                        answer += bandage[1];
                    } else {
                        answer = health;
                    }
                    n++;
                } 
                if(n == N) { // 추가 힐
                    if(answer+bandage[2] < health) {
                        answer += bandage[2];
                    }
                    else {
                        answer = health;
                    }
                    n=0;
                }
            }
        }
        // 1. 힐과 공격을 받음 시간마다.(공격이 우선권)
        // 2. 붕대감기 지속시간은 공격을 받거나 지속시간이 끝나면 0으로 초기화
        // 3. 최대 체력보다 커지지 않음
        
        return answer;
    }
}