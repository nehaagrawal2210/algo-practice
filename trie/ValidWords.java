package trie;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 3/6/2017.
 */
//http://www.geeksforgeeks.org/print-valid-words-possible-using-characters-array/
public class ValidWords extends TestCase{
    public void displayValidWords(Trie.TrieNode dict, char[] chars)
    {
        int hash[]= new int[Trie.TrieNode.ALPHABET_SIZE];
        for (int i = 0; i < chars.length; i++) {
            hash[Character.getNumericValue(chars[i])-Character.getNumericValue('a')]++;
        }

        String str="";
        searchWord(dict,hash,str);
    }

    public void searchWord(Trie.TrieNode root, int[] hash, String str)
    {
        if(root.isLeaf)
            System.out.println(str);
        for (int i = 0; i < Trie.TrieNode.ALPHABET_SIZE; i++) {
            if(hash[i]>0 && root.children[i]!=null)
            {
                char c= (char)(i+'a');
                searchWord(root.children[i],hash,str+c);
            }
        }
    }

    @Test
    public void testDisplayValidWords()
    {
        String[] dict = {"go", "bat", "me", "eat", "goal", "boy", "run"} ;
        char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;

        Trie trie = new Trie();
        for (int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        displayValidWords(trie.getRoot(),arr);
    }
}
