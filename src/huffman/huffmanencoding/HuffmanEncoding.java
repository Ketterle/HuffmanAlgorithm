package huffman.huffmanencoding;

import huffman.TextTools;

import java.util.*;

public class HuffmanEncoding {
    /**
     * Builds the Huffman code map for a given input string.
     *
     * @param inputString The input string to build the Huffman code map for.
     * @return The generated Huffman code map.
     */
    public static Map<String, String> buildHuffmanCodeMap(String inputString) {
        List<Map.Entry<String, Integer>> frequencyMap = TextTools.charactersFrequencyMap(inputString);
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(HuffmanNode::getFrequency));

        // Create initial Huffman nodes for each character and add them to the priority queue
        for (Map.Entry<String, Integer> entry : frequencyMap) {
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
            priorityQueue.add(node);
        }

        // Build the Huffman tree by repeatedly merging nodes until only one node remains
        while (priorityQueue.size() > 1) {
            HuffmanNode firstNode = priorityQueue.poll();
            HuffmanNode secondNode = priorityQueue.poll();

            assert secondNode != null;
            HuffmanNode mergedNode = new HuffmanNode(firstNode, secondNode);
            priorityQueue.add(mergedNode);
        }

        // Obtain the root node of the Huffman tree
        HuffmanNode rootNode = priorityQueue.poll();

        // Generate the Huffman codes by traversing the Huffman tree
        Map<String, String> huffmanCodeMap = new HashMap<>();
        assert rootNode != null;
        generateHuffmanCodes(rootNode, "", huffmanCodeMap);

        return huffmanCodeMap;
    }

    /**
     * Encodes a string using the given Huffman code map.
     *
     * @param inputString    The input string to be encoded.
     * @param huffmanCodeMap The Huffman code map.
     * @return The encoded string.
     */
    public static String encodeStringWithHuffman(String inputString, Map<String, String> huffmanCodeMap) {
        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            String character = String.valueOf(inputString.charAt(i));

            if (huffmanCodeMap.containsKey(character)) {
                encodedString.append(huffmanCodeMap.get(character));
            }
            // Ignore the character if it is not found in the Huffman code map
        }

        return encodedString.toString();
    }

    /**
     * Recursively generates the Huffman codes for each character in the Huffman tree.
     *
     * @param node           The current node in the Huffman tree.
     * @param code           The Huffman code built so far.
     * @param huffmanCodeMap The map to store the generated Huffman codes.
     */
    private static void generateHuffmanCodes(HuffmanNode node, String code, Map<String, String> huffmanCodeMap) {
        if (node.isLeaf()) {
            huffmanCodeMap.put(node.getCharacter(), code);
            return;
        }

        generateHuffmanCodes(node.getLeftChild(), code + "0", huffmanCodeMap);
        generateHuffmanCodes(node.getRightChild(), code + "1", huffmanCodeMap);
    }
}
