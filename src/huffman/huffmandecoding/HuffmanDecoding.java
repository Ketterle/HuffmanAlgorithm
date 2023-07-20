package huffman.huffmandecoding;

import java.util.Map;

public class HuffmanDecoding {

    // Method to decode Huffman-encoded text using a Huffman map
    public static String decodingHuffmanText(String stringToBeDecoded, Map<Character, String> huffmanMap) {
        StringBuilder sb = new StringBuilder(stringToBeDecoded);
        StringBuilder result = new StringBuilder();

        // Continue decoding until there are characters in the 'sb' StringBuilder
        while (sb.length() > 0) {
            for (Map.Entry<Character, String> entry : huffmanMap.entrySet()) {
                String value = entry.getValue();

                // Check if the 'sb' starts with the current Huffman code (value)
                if (sb.toString().startsWith(value)) {
                    // Append the corresponding character to the result and remove the processed code from 'sb'
                    result.append(entry.getKey());
                    sb.delete(0, value.length());
                    break; // Go to the next iteration of the while loop
                }
            }
        }

        return result.toString();
    }
}
