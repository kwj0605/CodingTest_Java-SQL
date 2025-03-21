import java.util.*;
class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        
        int lim = (int)Math.sqrt(num);
        
        for(int i=2; i<=lim; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
    public void recur(String comb, String numbers) {
        // 현재 조합을 numberSet에 저장한다.
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
    
        // 남은 숫자 중에서 한 개를 더 해 새로운 조합을 만든다.
        for(int i=0; i<numbers.length(); i++) {
            recur(comb+numbers.charAt(i), numbers.substring(0, i)+numbers.substring(i+1));
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        
        // 한문자씩 숫자 배열 생성
        recur("", numbers);
        
        // 숫자 하나씩 가져와서 소수 판단
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int num = it.next();
            if(isPrime(num)) {
                answer++;
            }
        }
        // 소수 개수 반환
        
        return answer;
    }
}