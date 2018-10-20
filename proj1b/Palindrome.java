public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> list = new LinkedListDeque<>();
        for (int i = 0; i<word.length(); i++) {
            list.addLast(word.charAt(i));
        }
        return list;
    }
    public boolean isPalindrome(String word) {
        if (word.length() < 2) return true;
        Deque<Character> list = wordToDeque(word);
        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 2) return true;
        Deque<Character> list = wordToDeque(word);
        while (list.size() > 1) {
            if (!cc.equalChars(list.removeFirst(), list.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
