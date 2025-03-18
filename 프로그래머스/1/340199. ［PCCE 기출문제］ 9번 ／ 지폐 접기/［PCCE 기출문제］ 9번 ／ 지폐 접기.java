// 1. wallet의 최대값, 최소값을 저장
// 2. bill에서 최대값, 최소값을 구해서 
// 3. if(bill의 최대값>wallet의 최대값 || bill의 최소값>wallet의 최소값)
// 4. bill의 최대값 = /2
// 5. bill의 최대값, 최소값 다시 정하기
// answer = 카운팅;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax, walletMin;
        int billMax, billMin;
        
        if(wallet[0]> wallet[1]) {
            walletMax=wallet[0]; walletMin=wallet[1];
        }
        else {
            walletMax=wallet[1]; walletMin=wallet[0];
        } 
        
        if(bill[0]> bill[1]) {
            billMax=bill[0]; billMin=bill[1];
        }
        else {
            billMax=bill[1]; billMin=bill[0];
        }
        
        while(billMax>walletMax || billMin>walletMin) {
            if(billMax/2 > billMin) {
                billMax = billMax/2;
                answer++;
            }
            else {
                int temp = billMax/2;
                billMax = billMin;
                billMin = temp;
                answer++;
            }
        }
        
        return answer;
    }
}