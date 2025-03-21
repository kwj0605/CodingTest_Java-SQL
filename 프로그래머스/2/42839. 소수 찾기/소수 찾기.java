import java.util.*;
class Solution {
    HashSet<Integer> numbersSet = new HashSet<>();
    void recur(String comp, String nums) {
        if(!comp.equals("")) {
            numbersSet.add(Integer.valueOf(comp));
        }
        
        for(int i=0; i<nums.length(); i++) {
            recur(comp+nums.charAt(i), nums.substring(0, i)+nums.substring(i+1));
        }
    }
    boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        
        int lim = (int)Math.sqrt(num);
        
        for(int i=2; i<=lim; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        int answer = 0;
        // 모든 숫자 배열 생성
        recur("", numbers);
        // 소수 인지 판단
        Iterator<Integer> it = numbersSet.iterator();
        
        while(it.hasNext()) {
            int num = it.next();
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
}