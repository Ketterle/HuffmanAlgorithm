package huffman.app;


import huffman.huffmandecoding.HuffmanDecoding;
import huffman.huffmanencoding.HuffmanEncoding;
import huffman.metrics.HuffmanEfficiency;
import huffman.texttools.TextTools;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String message = "Feel free to test this Huffman encoder in the way you want";
        String encodedMessage;

        // Generating Huffman code and printing it
        Map<Character,String> map = HuffmanEncoding.huffmanCode(message);
        System.out.println("The Huffman map is:");
        System.out.println(map);

        // Printing encoded message
        System.out.println("The encoded message is:");
        System.out.println(encodedMessage=HuffmanEncoding.encodeMessage(message));

        // Printing decoded message
        System.out.println("The decoded message is:");
        System.out.println(HuffmanDecoding.decodingHuffmanText(encodedMessage, map));

        //Printing code efficiency vs entropy
        System.out.println("The Shannon entropy of the message is: " + HuffmanEfficiency.entropyMessageCalculator(message));
        System.out.println("The average bits per symbol in Huffman encoding is: " + HuffmanEfficiency.huffmanEncodingAverageBits(message));
    }

}


