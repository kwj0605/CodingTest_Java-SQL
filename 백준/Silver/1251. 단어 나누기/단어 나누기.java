import java.util.*;

public class Main {

    static void dfs(List<String> words, String comp, String word, int depth) {
        if(depth==3) {
            words.add(comp);
            return;
        }

        String str;

        for(int i=1; i<=word.length(); i++) {
            str = word.substring(0, i);
            if(depth==2) {
                str = word;
            }
            dfs(words, comp+reverse(str), word.substring(i), depth+1);
        }
    }
    static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        sc.close();
        List<String> words = new ArrayList<>();

        dfs(words, "", word, 0);

        Collections.sort(words);

        System.out.println(words.get(0));
    }
}
