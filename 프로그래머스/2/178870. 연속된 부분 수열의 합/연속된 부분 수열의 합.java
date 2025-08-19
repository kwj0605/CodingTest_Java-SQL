class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length};
        
        int len = sequence.length;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        sum += sequence[right++];
        
        while(left < right) {
            if(sum == k) {
                if(answer[1] - answer[0] > right-1 - left) {
                    answer[1] = right-1;
                    answer[0] = left;
                }
                sum-=sequence[left++];
            }
            else if(sum > k) {
                sum -= sequence[left++];
            } 
            else if(right < len) {
                sum += sequence[right++];
            }
            else {
                break;
            }
        }
        
        return answer;
    }
}