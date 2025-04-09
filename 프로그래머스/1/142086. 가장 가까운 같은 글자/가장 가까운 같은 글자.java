class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alp = new int[26];
        
        for(int i=0; i<alp.length; i++) {
            alp[i] = -1;
        }
        
        for(int i=0; i<s.length(); i++) {
            int num = (int)s.charAt(i) - 97;
            if(alp[num] >= 0) {
                answer[i] = i - alp[num];
            }
            else {
                answer[i] = -1;
            }
            alp[num] = i;
        }
        
        return answer;
    }
}

// 1. 알파벳파벳 26자 담을 배열
// 2. 배열에 각 알파벳이 나온 번째 수 저장
