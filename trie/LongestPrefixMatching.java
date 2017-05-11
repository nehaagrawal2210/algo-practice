package trie;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
//http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
public class LongestPrefixMatching extends TestCase {
    public String getLongestMatchingPrefix(Trie dictionary, String key)
    {
        int index;
        String longestPrefix=null;
        Trie.TrieNode trieNode = dictionary.getRoot();
        for (int i = 0; i < key.length() && trieNode!= null; i++) {
            index = Character.getNumericValue(key.charAt(i)) - Character.getNumericValue('a');
            if(trieNode.children[index]!=null && trieNode.children[index].isLeaf)
                longestPrefix = key.substring(0,i+1);
            trieNode = trieNode.children[index];
        }
        return longestPrefix;
    }

    @Test
    public void testGetLongestPrefix()
    {
        String keys[]= {"are","area","base","cat","cater","basement"};

        Trie dictionary = new Trie();
        for (int i = 0; i < keys.length; i++) {
            dictionary.insert(keys[i]);
        }

        assertEquals(true,dictionary.search("area"));

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(getLongestMatchingPrefix(dictionary,input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(getLongestMatchingPrefix(dictionary,input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(getLongestMatchingPrefix(dictionary,input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(getLongestMatchingPrefix(dictionary,input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(getLongestMatchingPrefix(dictionary,input));

        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(getLongestMatchingPrefix(dictionary,input));
    }
}
