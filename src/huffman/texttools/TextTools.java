package huffman.texttools;

import java.util.*;

public class TextTools {

    // Method to calculate the frequency of characters in a given string
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

    // Method to get a list of distinct characters in a given string
    public static List<Character> distinctCharactersInString(String s) {
        return new ArrayList<>(s.replaceAll("\\\\.", "")
                .chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .toList());
    }

    // Method to merge characters based on their frequencies to build Huffman trees
    public static List<List<Map.Entry<String, Integer>>> mergeCharacters(String s) {
        List<List<Map.Entry<String, Integer>>> resultList = new ArrayList<>();

        List<Map.Entry<String, Integer>> characterFrequencyList = TextTools.charactersFrequencyMap(s);
        resultList.add(new ArrayList<>(characterFrequencyList));

        while (characterFrequencyList.size() > 1) {
            Map.Entry<String, Integer> firstEntry = characterFrequencyList.remove(0);
            Map.Entry<String, Integer> secondEntry = characterFrequencyList.remove(0);

            // Merge characters and their frequencies
            String mergedCharacters = firstEntry.getKey() + secondEntry.getKey();
            int mergedFrequency = firstEntry.getValue() + secondEntry.getValue();

            characterFrequencyList.add(0, new AbstractMap.SimpleEntry<>(mergedCharacters, mergedFrequency));
            characterFrequencyList.sort(Map.Entry.comparingByValue());

            resultList.add(new ArrayList<>(characterFrequencyList));
        }

        return resultList;
    }
}
