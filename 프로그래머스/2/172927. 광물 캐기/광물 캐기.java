import java.util.*;

class Solution {
    class MineralGroup implements Comparable<MineralGroup> {
        int diamond;
        int iron;
        int stone;
        
        MineralGroup(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
        
        @Override
        public int compareTo(MineralGroup other) {
            if(this.diamond != other.diamond) return other.diamond - this.diamond;
            if(this.iron != other.iron) return other.iron - this.iron;
            return other.stone - this.stone;
        }
        
    }
    public int solution(int[] picks, String[] minerals) {
        int picksLen = picks[0] + picks[1] + picks[2];
        int totalGroup = Math.min(picksLen, (minerals.length+4)/5); // (1)
        
        MineralGroup[] mineralGroup = new MineralGroup[totalGroup];
        
        for(int i=0; i<totalGroup; i++) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j=i*5; j<(i+1)*5 && j<minerals.length; j++) {
                if(minerals[j].equals("diamond")) diamond++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
            }
            
            mineralGroup[i] = new MineralGroup(diamond, iron, stone); // (2)
        }
        
        Arrays.sort(mineralGroup); // (3)
        
        int totalTired = 0;
        for(MineralGroup mg : mineralGroup) { // (4)
            
            if(picks[0] > 0) {
                totalTired += mg.diamond * 1 + mg.iron * 1 + mg.stone * 1;
                picks[0]--;
            }
            else if(picks[1] > 0) {
                totalTired += mg.diamond * 5 + mg.iron * 1 + mg.stone * 1;
                picks[1]--;
            }
            else if(picks[2] > 0) {
                totalTired += mg.diamond * 25 + mg.iron * 5 + mg.stone * 1;
            }
        }
        
        return totalTired;
    }
}

// 1. 곡괭이와 광물(5개씩) 중에서 몇 번까지 할 수 있는지 확인
// 2. 광물을 5개씩 묶어서 새로 만들기
// 3. 광물을 다이아 -> 철 -> 돌 이 많은 순으로 정렬하기
// 4. 다이아 -> 철 -> 돌 곡괭이로 순서대로 광물 캐기