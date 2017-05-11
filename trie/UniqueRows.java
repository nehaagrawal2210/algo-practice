package trie;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by neha on 2/22/2017.
 */
//http://www.geeksforgeeks.org/print-unique-rows/
public class UniqueRows extends TestCase{

    public void getUniqueRows(int[][] matrix)
    {
        int rows= matrix.length;
        BinaryTrie trie = new BinaryTrie();
        for (int i = 0; i < rows; i++) {
            if(trie.insert(matrix[i]))
                System.out.println(Arrays.toString(matrix[i]));
        }
    }

    @Test
    public void testGetUniqueRows()
    {
        int M[][] = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0,1,0,0}
        };
        getUniqueRows(M);
    }
}

class BinaryTrieNode {
    public static final int SIZE=2;
    boolean isLeaf;
    BinaryTrieNode child[];

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public BinaryTrieNode[] getChild() {
        return child;
    }

    public void setChild(BinaryTrieNode[] child) {
        this.child = child;
    }

    public BinaryTrieNode()
    {
        child = new BinaryTrieNode[SIZE];
        for (int i = 0; i < SIZE; i++) {
            child[i] = null;
        }
    }
}

class BinaryTrie{
    BinaryTrieNode root;

    public BinaryTrie() {
        root = new BinaryTrieNode();
    }

    public BinaryTrieNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTrieNode root) {
        this.root = root;
    }

    public boolean insert(int[] key)
    {
        int keyLen = key.length;
        BinaryTrieNode temp = getRoot();
        boolean inserted = false;
        for (int level = 0; level < keyLen; level++) {
            if(temp.child[key[level]]== null)
            {
                temp.child[key[level]]= new BinaryTrieNode();
            }
            temp = temp.child[key[level]];
        }
        if(!temp.isLeaf) {
            inserted = true; //in case the bits are already present but key is not marked
                             // such as prefix of already present key
            temp.isLeaf = true;
        }
        return inserted;
    }
}
