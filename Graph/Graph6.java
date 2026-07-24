import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph6 {
    static class Pair {
        String str;
        int lvl;

        Pair(String str, int lvl) {
            this.str = str;
            this.lvl = lvl;
        }
    }

    public static List<String> check(String word, Set<String> visited, int idx) {
        List<String> ans = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            if (arr[idx] != c) {
                arr[idx] = c;
                String newStr = new String(arr);
                if (visited.contains(newStr)) {
                    ans.add(newStr);
                    visited.remove(newStr);
                }
            }
        }
        return ans;
    }

    // Word Ladder 1
    public static int WordLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>(wordList);
        if (!visited.contains(endWord)) {
            return 0;
        }
        int n = beginWord.length();
        visited.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                List<String> list = check(p.str, visited, i);
                for (String str : list) {
                    if (str.equals(endWord)) {
                        flag = true;
                        return p.lvl + 1;
                    }
                    q.offer(new Pair(str, p.lvl + 1));
                }
            }
            if (flag)
                break;
        }

        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "toon";
        String endWord = "plea";

        List<String> wordList = Arrays.asList(
                "poon",
                "plee",
                "same",
                "poie",
                "plie",
                "poin",
                "plea");

        System.out.println(WordLadder(beginWord, endWord, wordList));

    }

}
