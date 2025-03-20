import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n=nums.length/2;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        if(set.size()>n) answer=n;
        else answer=set.size();
        
        return answer;
    }
}
// 중복되지않은 개수 -> set사용
// if 중복되지 않는 갯수 > N/2 =N/2
// else 중복되지 않는 갯수