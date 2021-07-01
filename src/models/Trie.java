package models;

import java.util.List;

public class Trie {

    class TrieNode {
        public TrieNode[] children;
        public boolean isLeaf;
        final private int CHILDREN_SIZE = 26;

        public TrieNode() {
            this.children = new TrieNode[CHILDREN_SIZE];
            this.isLeaf = false;
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (int i=0; i<word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        for (int i=0; i<word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        return node != null && node.isLeaf;
    }

}
