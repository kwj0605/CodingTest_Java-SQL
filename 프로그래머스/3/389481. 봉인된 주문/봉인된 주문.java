import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        Queue<String> banQ = new ArrayDeque<>();    // 밴할 내용들 저장
        
        Arrays.sort(bans, (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2); // 길이가 같으면 문자 오름차순
            return o1.length() - o2.length();   // 길이 다르면 길이가 작은 순서
        });
        
        // 밴할 주문 저장
        for(String ban : bans) {
            banQ.offer(ban);
        }
        
        while(!banQ.isEmpty()) {
            String cur = banQ.peek();
            String target = getString(n); // n 번째 주문 찾기
            
            // 봉인된 주문이 n번째 주문보다 길이가 작거나, 문자가 앞에 있을 때
            if(cur.length() < target.length() || (cur.length() == target.length() && cur.compareTo(target) <= 0)) {
                banQ.poll(); // 사용된 금지된 주문은 빼낸다.
                n++; // 그 다음 문자를 찾음
            } else {
                break;
            }
        }
        
        return getString(n);
    }
    
    private String getString(long n) {
        StringBuilder sb = new StringBuilder(); // 주문을 만들 빌더
        while(n>0) {
            long remained = n%26;   // 알파벳이 26자이므로 26씩 나눔
            n /= 26;
            if(remained == 0) {
                sb.append('z');
                n--;
            } else {
                sb.append((char)('a'+ remained - 1));   // a에서 나머지만큼 더해서 해당 영어의 숫자
            }
        }
        
        return sb.reverse().toString(); // 뒤에서부터 주문을 만들어 나갔으니, reverse 필요
    }
}