# Huffman Coding Application

This is a Java application that demonstrates Huffman coding, a popular data compression algorithm. Huffman coding efficiently compresses data by assigning shorter codes to more frequently occurring characters and longer codes to less frequent ones.

## Usage

1. Clone the repository to your local machine using the following command:
Replace `YourUsername` with your GitHub username.

2. Compile and run the `Main.java` file to see the Huffman coding process in action:


3. The application will display the following outputs:
- The Huffman map, which shows the Huffman codes generated for each character in the input message.
- The encoded message, which represents the original message after Huffman encoding.
- The decoded message, which is obtained by decoding the encoded message back to the original text using the Huffman codes.

## Project Structure

The repository contains the following files and directories:

1. `Main.java`: The main class that demonstrates the complete Huffman coding process.

2. `huffman/huffmanencoding/HuffmanEncoding.java`: Contains methods to generate Huffman codes for characters in a given string and encode a message using Huffman codes.

3. `huffman/huffmandecoding/HuffmanDecoding.java`: Provides a method to decode Huffman-encoded text using a given Huffman map.

4. `huffman/metrics/HuffmanEfficiency.java`: Contains methods to calculate the efficiency of Huffman coding by calculating the Shannon entropy of the original message and the average bits per symbol after Huffman encoding.

5. `huffman/texttools/TextTools.java`: Contains utility methods for character frequency calculation, merging characters, and finding distinct characters in a string.

## Note

This application is designed as a demonstration of Huffman coding and is not optimized for large-scale compression. For real-world compression tasks, consider using established libraries and algorithms.

## Author

Toni Llombart
