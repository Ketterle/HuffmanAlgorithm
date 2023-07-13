package huffman;

import java.util.*;

public class TextTools {

    /**
     * Calculates the frequency map of characters in a given string.
     *
     * @param s The input string.
     * @return A list of Map.Entry objects representing the character-frequency mapping,
     *         sorted by the frequency in ascending order.
     */
    public static List<Map.Entry<String, Integer>> charactersFrequencyMap(String s) {
        Map<String, Integer> mapToBeReturned = new HashMap<>();

        // Convert the input string into a list of characters, excluding newline characters
        List<Character> charactersInString = s.replaceAll("\\\\.", "").chars()
                .mapToObj(c -> (char) c)
                .toList();

        // Iterate over distinct characters in the string and calculate their frequencies
        for (Character c : distinctCharactersInString(s)) {
            if (c != '\n') {  // Exclude the newline character
                String characterAsString = c.toString();
                mapToBeReturned.put(characterAsString, Collections.frequency(charactersInString, c));
            }
        }

        // Sort the character-frequency mapping by the frequency in ascending order
        return new ArrayList<>(mapToBeReturned.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList());
    }

    /**
     * Returns a list of distinct characters in the given string.
     *
     * @param s The input string.
     * @return A list of distinct characters in the string.
     */
    public static List<Character> distinctCharactersInString(String s) {
        return  new ArrayList<>(s.replaceAll("\\\\.", "")
                .chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .toList());
    }
}
