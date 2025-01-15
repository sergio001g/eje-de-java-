public class E07_WordLadder {
    public static int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
        java.util.Set<String> dictionary = new java.util.HashSet<>(wordList);
        if (!dictionary.contains(endWord)) return 0;
        
        java.util.Queue<String> queue = new java.util.LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();
                
                for (int j = 0; j < wordChars.length; j++) {
                    char original = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        
                        if (newWord.equals(endWord)) return level + 1;
                        
                        if (dictionary.contains(newWord)) {
                            queue.offer(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                    wordChars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}