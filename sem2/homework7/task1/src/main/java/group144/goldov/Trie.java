package group144.goldov;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/** Implementation of the trie data structure */
public class Trie {
    private final int alphabetSize = 26;
    private int size;
    private TrieNode root = new TrieNode();
    private ArrayList<String> serialisator = new ArrayList<>();

    /**
     * Adds new string to the trie
     * @param element string that is added
     * @return true if the string is not in the trie, false if string is already in the trie
     */
    public boolean add(String element) {
        if (contains(element)) {
            return false;
        }
        serialisator.add(element);
        size++;
        TrieNode current = root;
        for (int i = 0; i < element.length(); i++) {
            TrieNode node = current.children.get(element.charAt(i));
            current.prefixCounter++;
            if (node == null) {
                node = new TrieNode();
                current.children.put(element.charAt(i), node);
            }
            current = node;
        }
        current.isEndOfWord = true;
        return true;
    }

    /**
     * Checks if the string in the trie
     * @param element string that is found
     * @return true if the string in the trie, false otherwise
     */
    public boolean contains(String element) {
        TrieNode current = root;
        for (int i = 0; i < element.length(); i++) {
            TrieNode node = current.children.get(element.charAt(i));
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    /**
     * Removed string from the trie
     * @param element string that is removed
     * @return true if such string is in the trie, false if not
     */
    public boolean remove(String element) {
        if (contains(element)) {
            size--;
            remove(root, element, 0);
            return true;
        }
        return false;
    }

    /**
     * Recursive removing from the trie
     * @param current trie node that is checked to be delete
     * @param element string that is deleted
     * @param index of the string
     * @return true if parent should delete the mapping
     */
    private boolean remove(TrieNode current, String element, int index) {
        if (index == element.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.size() == 0;
        }
        char character = element.charAt(index);
        TrieNode node = current.children.get(character);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = remove(node, element, index + 1);
        if (shouldDeleteCurrentNode) {
            current.children.remove(character);
            return current.children.size() == 0;
        }
        return false;
    }

    /**
     * Getter for the size field
     * @return quantity of strings in the trie
     */
    public int getSize() {
        return size;
    }

    /**
     * Counts strings that start with the prefix
     * @param prefix string with should start strings of trie
     * @return quantity of such strings
     */
    public int howManyStartWithPrefix(String prefix) {
        TrieNode current = root;
        int answer = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.children.containsKey(prefix.charAt(i))) {
                current = current.children.get(prefix.charAt(i));
                answer += current.children.size();
            } else {
                return 0;
            }
        }
        if (contains(prefix)) {
            return current.prefixCounter + 1;
      }
        return current.prefixCounter;
    }

    /**
     * Writes trie to the to the output stream
     * @param out stream into which trie is written
     * @throws IOException is thrown if trie can't be written
     */
    public void serialise(OutputStream out) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        for (int i = 0; i < serialisator.size(); i++) {
            writer.write(serialisator.get(i));
            writer.write("\n");
        }
        writer.close();
    }

    /**
     * Replaces current trie with the one from the stream
     * @param in stream in which new trie is stored
     * @throws IOException is thrown if stream can't be read
     */
    public void deserialise(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Trie newTrie = new Trie();
        while (reader.ready()) {
            String element = reader.readLine();
            newTrie.add(element);
        }
        root = newTrie.root;
        serialisator = newTrie.serialisator;
        size = newTrie.size;
    }

    private class TrieNode implements Serializable {
        private HashMap <Character, TrieNode> children;
        private boolean isEndOfWord;
        private int prefixCounter;

        private TrieNode() {
            children = new HashMap<>(alphabetSize);
            isEndOfWord = false;
            prefixCounter = 0;
        }
    }
}
