class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");
        int cnt =0;
        for (String str : strArr) {
            if(str.contains(" ")){
                cnt=0;
            } else {
                cnt++;
            }
            if(cnt%2==0) {
                answer += str.toLowerCase();
            }
            else {
                answer += str.toUpperCase();
            }
        }
        return answer;
    }
}