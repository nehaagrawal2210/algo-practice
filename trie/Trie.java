package trie;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/16/2017.
 */
//http://www.geeksforgeeks.org/trie-insert-and-search/
public class Trie extends TestCase{

    TrieNode root;

    public Trie(){
        root= new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    class TrieNode{
        public static final int ALPHABET_SIZE=26; //

        boolean isLeaf;
        TrieNode children[];

        public TrieNode()
        {
            //initialize new trie node
            isLeaf=false;
            children= new TrieNode[ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i]=null;
            }
        }

    }

    //insert the key in the Trie O(keylen) space-O(ALPHABET-SIZE*keyLen*no of keys)
    public void insert(String key)
    {
        int keyLen= key.length(),index;
        
        TrieNode tempRoot= root;
        for (int level = 0; level < keyLen; level++) {
            index = Character.getNumericValue(key.charAt(level))- Character.getNumericValue('a');
            if(tempRoot.children[index]==null)
                tempRoot.children[index]= new TrieNode();
            tempRoot= tempRoot.children[index];
        }
        tempRoot.isLeaf=true;
    }

    //search the key in the trie O(keyLen)
    public boolean search(String key)
    {
        int keyLen = key.length(),index;

        TrieNode tempRoot= root;
        for (int level = 0; level < keyLen && tempRoot!=null; level++) {
            index = Character.getNumericValue(key.charAt(level))- Character.getNumericValue('a');
            if(tempRoot.children[index]==null)
                return false;
            tempRoot= tempRoot.children[index];
        }
        return (tempRoot!=null && tempRoot.isLeaf);
    }

    public boolean delete(TrieNode trie,String key,int level,int keyLen)
    {
        if(trie == null)
            return false;
        int index;
        if(level == keyLen)
        {
            //last character
            if(trie.isLeaf)
            {
                trie.isLeaf = false; //unmark this key
                if(isFree(trie))
                    return true; //if children are not present then remove previous chars, this key is not prefix of other key
                return false;
            }
        }
        else{
            index = Character.getNumericValue(key.charAt(level)) - Character.getNumericValue('a');
            if(delete(trie.children[index],key,level+1,keyLen))
            {
                //remove this char
                trie.children[index]= null;
                //return if the uppers can be deleted
                return (!trie.isLeaf && isFree(trie));
            }
        }
        return false;
    }

    public void deleteKey(String key)
    {
        int keyLen = key.length();
        if(keyLen>0)
            delete(this.root,key,0,keyLen);
    }

    public boolean isFree(TrieNode trie)
    {
        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            if(trie.children[i]!= null)
                return false;
        }
        return true;
    }


    @Test
    public void testTrie()
    {
        String keys[]= {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        Trie r = new Trie();
        for (int i = 0; i < keys.length; i++) {
            r.insert(keys[i]);
        }
        assertEquals(true,r.search("the"));
        assertEquals(false,r.search("these"));
        assertEquals(false,r.search("an"));
        assertEquals(true,r.search("their"));
        assertEquals(false,r.search("thaw"));

        r.deleteKey("the");
        assertEquals(false,r.search("the"));
        assertEquals(true,r.search("there"));
        assertEquals(true,r.search("their"));

        r.deleteKey("answer");
        assertEquals(true,r.search("a"));
        assertEquals(true,r.search("any"));
        assertEquals(false,r.search("answer"));
    }
}
