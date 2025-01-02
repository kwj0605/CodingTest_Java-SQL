class Solution {
    public String solution(int[] food) {
        String answer = "";

        int[] halfFood = new int[food.length];

        // 음식을 반 나누기
        for (int i = 0; i < food.length; i++) {
            if(i==0) halfFood[i] = food[i];
            else {
                halfFood[i] = food[i]/2;
            }
        }

        // 왼쪽 음식 생성
        StringBuilder foods = new StringBuilder();
        for (int i = 1; i < halfFood.length; i++) {
            for (int j = 0; j < halfFood[i]; j++) {
                foods.append(i);
            }
        }
        String leftFood = foods.toString();

        // 오른쪽 음식 생성
        String rightFood = foods.reverse().toString();

        // 음식 순서 조합
        answer = leftFood + "0" + rightFood;

        return answer;
    }
}
