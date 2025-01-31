import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {


        final int KEYMAP_LENGTH = keymap.length;
        final int TARGETS_LENGTH = targets.length;

        int[] answer = new int[TARGETS_LENGTH];

        // keymap의 문자의 최소값부터 다 찾기
        HashMap<Character, Integer> targetInKeymap = new HashMap<>();

        for (int i = 0; i < KEYMAP_LENGTH; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char thisChar = keymap[i].charAt(j);
                if (targetInKeymap.get(thisChar) == null) targetInKeymap.put(thisChar, j + 1);
                if (targetInKeymap.get(thisChar) > j + 1) targetInKeymap.put(thisChar, j + 1);
            }
        }

        // 적용
        for (int i = 0; i < TARGETS_LENGTH; i++) {
            int total = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                Integer minTarget = targetInKeymap.get(targets[i].charAt(j));
                if (minTarget == null) {
                    total = -1;
                    break;
                }
                total += minTarget;
            }
            answer[i] = total;
        }

        return answer;
    }
}