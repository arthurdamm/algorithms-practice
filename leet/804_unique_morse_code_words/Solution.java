// LeetCode 804. Unique Morse Code Words
// O(nm) time, O(nm) space
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String morseChars[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                sb.append(morseChars[word.charAt(i) - 'a']);
            uniqueWords.add(sb.toString());
        }
        return uniqueWords.size();
    }
}

