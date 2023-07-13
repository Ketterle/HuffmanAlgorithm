package huffman.metrics;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class HuffmanEfficiency {
    /**
     * Calculates the entropy of a Huffman map.
     *
     * @param huffmanMap The Huffman map as a list of Map.Entry objects, where the key represents the character
     *                   and the value represents its frequency.
     * @return The calculated entropy value.
     */
    public static double entropyHuffmanCalculator(List<Map.Entry<String, Integer>> huffmanMap) {
        AtomicReference<Double> entropy = new AtomicReference<>((double) 0);

        // Calculate the total number of characters in the Huffman map
        int numOfChars = huffmanMap.stream().mapToInt(Map.Entry::getValue).sum();

        // Calculate the entropy using the given Huffman map
        huffmanMap.forEach(entry -> {
            double probability = (double) entry.getValue() / numOfChars;
            entropy.updateAndGet(v -> v - probability * Math.log(probability));
        });

        return entropy.get();
    }
}
