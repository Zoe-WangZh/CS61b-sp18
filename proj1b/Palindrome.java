import java.util.function.Function;
import java.util.function.Predicate;

public class Palindrome {

    public Deque<Character> wordToDeque(String s) {
        Deque<Character> worddeque = new LinkedListDeque<>();

        for (int i = 0; i < s.length(); i++) {
            worddeque.addLast(s.charAt(i));
        }
        return worddeque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 1) {
            return true;
        }

        int i = 0;
        int j = word.length() - 1;

        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    public boolean isPalindrome(Deque<Character> q) {
        if (q.size() <= 1) {
            return true;
        }
        return q.removeFirst() == q.removeLast() && isPalindrome(q);
    }


    public boolean helper(Deque<Character> q, CharacterComparator cc) {
        if (q.size() <= 1) {
            return true;
        }
        return cc.equalChars(q.removeFirst(), q.removeLast()) && helper(q,cc);
    }

    // TO determine whether a word is a off-by-one palindrome
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return helper(wordToDeque(word), cc);

        /*
        Predicate<Deque<Character>> f = qq -> {   //Function f 闭包
            if (qq.size() <= 1) {
                return true;
            }
            return cc.equalChars(qq.removeFirst(), qq.removeLast()) && isPalindrome(qq);
        };

        return f.test(q);
         */
    }
}
