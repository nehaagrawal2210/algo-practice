package practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutocompleteSystem {

    Trie trie;
    StringBuilder currInput;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        int degree;
        static final int CHAR_SIZE = 27;

        public int getCharSize() {
            return CHAR_SIZE;
        }

        public TrieNode() {
            children = new TrieNode[CHAR_SIZE];
            isWord = false;
            degree = 0;
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private int getIndex(char c) {
            if (c == ' ') {
                return (int) c - 6;
            }
            return c - 'a';
        }

        private char getCharFromIndex(int index) {
            if (index == 26) {
                return ' ';
            }
            return (char) (index + 'a');
        }

        public void insert(String word, int degree) {
            int keyLen = word.length();
            TrieNode temp = root;
            for (int i = 0; i < keyLen; i++) {
                int index = getIndex(word.charAt(i));
                if (temp.children[index] == null) {
                    temp.children[index] = new TrieNode();
                }
                temp = temp.children[index];
            }
            temp.isWord = true;
            temp.degree += degree;
        }

        private void getSentencesWithPrefix(TrieNode root, List<Sentence> out, StringBuilder prefix) {
            if (root == null) {
                return;
            }

            if (root.isWord) {
                out.add(new Sentence(prefix.toString(), root.degree));
            }

            for (int i = 0; i < root.getCharSize(); i++) {
                char c = getCharFromIndex(i);
                prefix.append(c);
                getSentencesWithPrefix(root.children[i], out, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

        public List<Sentence> getSentencesWithPrefix(String prefix) {
            TrieNode temp = root;
            List<Sentence> out = new ArrayList<>();
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = getIndex(c);
                if (temp.children[index] == null) {
                    return out;
                }
                temp = temp.children[index];
            }
            getSentencesWithPrefix(temp, out, new StringBuilder(prefix));
            return out;
        }
    }

    class Sentence implements Comparable<Sentence> {
        String sentence;
        int degree;

        public Sentence(String s, int deg) {
            sentence = s;
            degree = deg;
        }

        @Override
        public int compareTo(Sentence o) {
            if (degree != o.degree) {
                return o.degree - degree;
            }
            return sentence.compareTo(o.sentence);
        }

        public String getSentence() {
            return sentence;
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        currInput = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    private void saveSentenceInHistory() {
        String sentenceToAdd = currInput.toString();

        // refresh input
        currInput = new StringBuilder();
        trie.insert(sentenceToAdd, 1);
    }

    public List<String> input(char c) {
        if (c == '#') {
            saveSentenceInHistory();
            return new ArrayList<>();
        }

        currInput.append(c);
        List<Sentence> out = trie.getSentencesWithPrefix(currInput.toString());
        Collections.sort(out);
        List<String> res = out.stream()
                .map(sentence -> sentence.getSentence()).limit(3).collect(Collectors.toList());
        return res;
    }
}