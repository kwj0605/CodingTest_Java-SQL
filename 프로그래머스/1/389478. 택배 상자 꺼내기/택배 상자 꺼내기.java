class Solution {
    
    int w, n, num, h;
    int[][] box;
    int answer = 0;
    
    public int solution(int n, int w, int num) {
        
        this.w = w;
        this.n = n;
        this.num = num;
        
        buildBox();
        findAnswer();
        
        return answer;
    }
    
    void buildBox() {
        // 열 개수
        if(n%w == 0) {
            h = n / w;
        }
        h = n/w+1;
        
        box = new int[h][w];
        
        // 박스 초기화
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                box[i][j] = 0;
            }
        }
        
        int nh = 0;
        int nw = 0;
        for(int i=1; i<=n; i++) {
            box[nh][nw] = i;
            if(nh%2 ==0) {
                nw++;
                if(nw == w) {
                    nh++;
                    nw--;
                }
            } else {
                nw--;
                if(nw == -1) {
                    nh++;
                    nw++;
                }
            }
        }
    }
    
    
    int xw, xh;
    void findAnswer() {
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(box[i][j] == num) {
                    xh = i;
                    xw = j;
                }
            }
        } 
        
        // 맨위 상자가 0일 때 포함
        if(box[h-1][xw] == 0) {
            answer = h-xh-1;
            System.out.println(box[h-1][xw]);
            System.out.println(box[h-2][xw]);
            System.out.println(box[xh][xw]);
            System.out.println(xh);
            System.out.println(h);
        } else{
            answer = h-xh;
        }
    }
}

// 1. 택배 쌓기
// 2. 2차원배열로 쌓아서 위쪽 방향으로 탐색2차원배열로 쌓아서 위쪽 방향으로 탐색