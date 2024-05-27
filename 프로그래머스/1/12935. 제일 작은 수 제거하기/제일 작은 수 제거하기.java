class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length - 1];
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) min = arr[i];
            else if (arr[i] < min) {
                min = arr[i];
            }
        }

        int k = 0;
        int z = 0;
        for (int j = 0; j < arr.length-1; j++) {
            if (arr[z] == min) {
                z++;
            }
            answer[k] = arr[z];
            k++;
            z++;
        }

        return answer;

    }
}