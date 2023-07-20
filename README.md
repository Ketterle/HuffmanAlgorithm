Huffman Encoding and Decoding

This repository contains Java classes for Huffman encoding and decoding. Huffman coding is a lossless data compression algorithm that assigns variable-length codes to different characters based on their frequencies, allowing efficient representation of the data.

Contents:
- `huffman` package: Contains classes for Huffman encoding and decoding.
- `huffman.huffmanencoding`: Includes classes for building Huffman code maps and encoding strings.
- `huffman.huffmandecoding`: Includes classes for decoding Huffman-encoded strings.
- `huffman.metrics`: Contains a class for calculating the entropy of a Huffman map.
- `Main.java`: A sample program demonstrating the usage of the Huffman encoding and decoding functionalities.

Usage:
1. Import the `huffman` package into your Java project.
2. Use the `HuffmanEncoding` class to build Huffman code maps and encode strings.
3. Use the `HuffmanDecoding` class to decode Huffman-encoded strings.
4. Use the `HuffmanEfficiency` class to calculate the entropy of a Huffman map.
5. Refer to the `Main.java` file for a sample implementation showcasing the functionalities.

Note: The Huffman encoding and decoding classes depend on the `TextTools` and `HuffmanNode` classes, which are included in the respective packages.

Example:
```java
import huffman.huffmanencoding.HuffmanEncoding;
import huffman.huffmandecoding.HuffmanDecoding;
import huffman.metrics.HuffmanEfficiency;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage
        String inputString = "Sample input string for Huffman encoding and decoding.";
        
        // Build Huffman code map
        Map<String, String> huffmanCodeMap = HuffmanEncoding.buildHuffmanCodeMap(inputString);
        
        // Encode string using Huffman code map
        String encodedString = HuffmanEncoding.encodeStringWithHuffman(inputString, huffmanCodeMap);
        
        // Decode string using Huffman code map
        String decodedString = HuffmanDecoding.decodingHuffmanText(encodedString, huffmanCodeMap);
        
        // Calculate Huffman map entropy
        List<Map.Entry<String, Integer>> huffmanMap = TextTools.charactersFrequencyMap(inputString);
        double entropy = HuffmanEfficiency.entropyHuffmanCalculator(huffmanMap);
        
        // Print the results
        System.out.println("Original string: " + inputString);
        System.out.println("Encoded string: " + encodedString);
        System.out.println("Decoded string: " + decodedString);
        System.out.println("Entropy of Huffman map: " + entropy);
    }
}
