package huffman.huffmanencoding;

class HuffmanNode implements Comparable<HuffmanNode> {
    private final String character;     // The character stored in the node (null for internal nodes)
    private final int frequency;        // The frequency of the character (sum of frequencies for internal nodes)
    private final HuffmanNode leftChild;   // The left child node
    private final HuffmanNode rightChild;  // The right child node

    /**
     * Constructs a leaf node for a character with its frequency.
     *
     * @param character The character stored in the node.
     * @param frequency The frequency of the character.
     */
    public HuffmanNode(String character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructs an internal node by merging two child nodes.
     *
     * @param leftChild  The left child node.
     * @param rightChild The right child node.
     */
    public HuffmanNode(HuffmanNode leftChild, HuffmanNode rightChild) {
        this.character = null;
        this.frequency = leftChild.getFrequency() + rightChild.getFrequency();
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Returns the character stored in the node.
     *
     * @return The character stored in the node (null for internal nodes).
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Returns the frequency of the character.
     *
     * @return The frequency of the character (sum of frequencies for internal nodes).
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Returns the left child node.
     *
     * @return The left child node.
     */
    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    /**
     * Returns the right child node.
     *
     * @return The right child node.
     */
    public HuffmanNode getRightChild() {
        return rightChild;
    }

    /**
     * Checks if the node is a leaf node.
     *
     * @return true if the node is a leaf node, false otherwise.
     */
    public boolean isLeaf() {
        return character != null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(frequency, other.frequency);
    }
}
