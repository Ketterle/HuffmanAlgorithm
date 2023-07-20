package huffman.huffmanencoding;

import huffman.texttools.TextTools;

import java.util.*;

public class HuffmanEncoding {

    // Method to generate Huffman codes for characters in a given string
    public static Map<Character, String> huffmanCode(String s) {
        List<List<Map.Entry<String, Integer>>> mergedCharacters = TextTools.mergeCharacters(s);
        Collections.reverse(mergedCharacters);
        List<Character> distinctCharacters = TextTools.distinctCharactersInString(s);
        Map<Character, String> mapToBeReturned = new HashMap<>();

        for (Character c : distinctCharacters) {
            StringBuilder value = new StringBuilder();

            // Handling the special case where there is only one distinct character in the string
            if (distinctCharacters.size() == 1) {
                value.append("1");
            } else {
                // Iterate over the merged characters to create the Huffman code
                for (List<Map.Entry<String, Integer>> list : mergedCharacters) {
                    if (list.size() == 1) {
                        continue;
                    } else if (list.get(0).getKey().contains(c.toString())) {
                        value.append("0");
                    } else if (list.get(1).getKey().contains(c.toString())) {
                        value.append("1");
                    }
                }
            }
            // Store the Huffman code for the character in the map
            mapToBeReturned.put(c, value.toString());
        }
        return mapToBeReturned;
    }

    // Encodes message given the Huffman map
    public static String encodeMessage(String message) {
        Map<Character, String> huffmanCodeMap = huffmanCode(message);
        StringBuilder encodedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            String huffmanSymbol = huffmanCodeMap.get(c);
            encodedMessage.append(huffmanSymbol);
        }

        return encodedMessage.toString();
    }

}
