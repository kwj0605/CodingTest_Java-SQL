import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String word;

        int count = 0;

        for (int i = 0; i < N; i++) {
            word = sc.next();
            if (checkGroupWord(word)) {
                count +=1;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean checkGroupWord(String word) {
        int[] alphabet = new int[26];
        // 알파벳 초기화
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = 0;
        }
        
        for (int i = 0; i < word.length(); i++) {
            // 1번째 단어의 알파벳
            if (i == 0) {
                alphabet[word.charAt(i)-97] = 1;
                continue;
            }
            // 다른 알파벳이 나온 경우
            if (word.charAt(i-1) != word.charAt(i)) {
                // 그룹 단어인 경우 faulse 반환
                if (alphabet[word.charAt(i)-97] == 1) {
                    return false;
                }
                alphabet[word.charAt(i)-97] = 1;
            }
        }
        return true;
    }
}
