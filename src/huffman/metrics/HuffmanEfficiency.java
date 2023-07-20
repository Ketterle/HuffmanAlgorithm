package huffman.metrics;

import huffman.huffmanencoding.HuffmanEncoding;
import huffman.texttools.TextTools;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HuffmanEfficiency {

    // Method to calculate the entropy of a given message
    public static double entropyMessageCalculator(String message) {
        List<Map.Entry<String, Integer>> charactersMap = TextTools.charactersFrequencyMap(message);
        double entropy = 0;

        // Calculate the total number of characters in the message
        int numOfChars = charactersMap.stream().mapToInt(Map.Entry::getValue).sum();

        // Calculate the entropy using the given message
        for (Map.Entry<String, Integer> entry : charactersMap) {
            double probability = (double) entry.getValue() / numOfChars;
            entropy -= probability * Math.log(probability) / Math.log(2); // Using base-2 logarithm
        }
        return entropy;
    }

    // Method to calculate the average bits per symbol after Huffman encoding
    public static double huffmanEncodingAverageBits(String message) {
        Map<Character, String> huffmanCodeMap = HuffmanEncoding.huffmanCode(message);
        List<Character> distinctCharacters = TextTools.distinctCharactersInString(message);

        double averageBits = 0.0;
        int totalCharacters = message.length();

        for (Character c : distinctCharacters) {
            String huffmanCode = huffmanCodeMap.get(c);
            int characterFrequency = Collections.frequency(message.chars().mapToObj(ch -> (char) ch).toList(), c);
            double characterProbability = (double) characterFrequency / totalCharacters;
            double bits = characterProbability * huffmanCode.length();
            averageBits += bits;
        }

        return averageBits;
    }
}
