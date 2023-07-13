package huffman.huffmandecoding;

import java.util.Map;

public class HuffmanDecoding {
    public static String decodingHuffmanText(String stringToBeDecoded, Map<String, String> huffmanMap) {
        StringBuilder sb = new StringBuilder(stringToBeDecoded);
        StringBuilder result = new StringBuilder();

        while (sb.length() > 0) {
            for (Map.Entry<String, String> entry : huffmanMap.entrySet()) {
                String value = entry.getValue();

                if (sb.toString().startsWith(value)) {
                    result.append(entry.getKey());
                    sb.delete(0, value.length());
                    break;
                }
            }
        }

        return result.toString();
    }

}
