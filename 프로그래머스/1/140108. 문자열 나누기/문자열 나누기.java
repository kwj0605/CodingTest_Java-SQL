class Solution {

    public int solution(String s) {
        int answer = 0;

        // s 첫 글자 추출
        Character c = s.charAt(0);

        // x와 x가 아닌 카운트
        int countX = 0, countOther = 0;

        // 순회
        for (int i = 0; i < s.length(); i++) {

            // 횟수 비교
            if(countX != 0 && countOther != 0 && countX == countOther) {
                // 문자열 분리
                answer++;
                // 분리한 문자열 첫 글자 추출
                c = s.charAt(i);
            }

            // 비교
            if (c.equals(s.charAt(i))) {
               countX++;
            } else countOther++;

        }
        
        // 끝까지 도달했을 때 문자열 분리
        answer++;

        return answer;
    }
}