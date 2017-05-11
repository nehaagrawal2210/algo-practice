package trie;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
public class ReverseDNSCache extends TestCase {
//    http://www.geeksforgeeks.org/implement-reverse-dns-look-cache/
    public ReverseDNSCacheTrie createCache(String ipAddreses[], String urls[]){
        ReverseDNSCacheTrie dnsCache = new ReverseDNSCacheTrie();
        for (int i = 0; i < ipAddreses.length; i++) {
            dnsCache.insertIP(ipAddreses[i],urls[i]);
        }
        return dnsCache;
    }

    public void printUrls(ReverseDNSCacheTrie cache, String[] ipAddress)
    {
        for (int i = 0; i < ipAddress.length; i++) {
            System.out.println(cache.searchIP(ipAddress[i]));
        }
    }

    @Test
    public void testReverseDNSCache()
    {
        String ipAdd[] = {"107.108.11.123", "107.109.123.255", "74.125.200.106"};
        String ipAddreses[] = {"107.108.11.123", "107.109.123.255", "74.125.200.106","107.108."};
        String URL[] = {"www.samsung.com", "www.samsung.net", "www.google.in"};
        ReverseDNSCacheTrie cache= createCache(ipAdd,URL);
        printUrls(cache,ipAddreses);
    }
}

class ReverseDNSCacheTrieNode {
    public static final int SIZE=11;
    String url;
    ReverseDNSCacheTrieNode children[];
    boolean isLeaf;

    public ReverseDNSCacheTrieNode()
    {
        isLeaf= false;
        url=null;
        children= new ReverseDNSCacheTrieNode[SIZE];
        for (int i = 0; i < SIZE; i++) {
            children[i]= null;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ReverseDNSCacheTrieNode[] getChildren() {
        return children;
    }

    public void setChildren(ReverseDNSCacheTrieNode[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}

class ReverseDNSCacheTrie{
    ReverseDNSCacheTrieNode cache;

    public ReverseDNSCacheTrie()
    {
        cache = new ReverseDNSCacheTrieNode();
    }

    public int getCharacterIndex(char c)
    {
        return (c=='.')? 10 : Character.getNumericValue(c)- Character.getNumericValue('0');
    }

    public ReverseDNSCacheTrieNode getCache() {
        return cache;
    }

    public void setCache(ReverseDNSCacheTrieNode cache) {
        this.cache = cache;
    }

    public void insertIP(String ipAddress, String url)
    {
        int addressLen = ipAddress.length(),index;
        ReverseDNSCacheTrieNode cacheTrie = getCache();
        for (int i = 0; i < addressLen; i++) {
            index = getCharacterIndex(ipAddress.charAt(i));
            if(cacheTrie.children[index]== null)
                cacheTrie.children[index] = new ReverseDNSCacheTrieNode();
            cacheTrie = cacheTrie.children[index];
        }

        //mark leaf node & place url
        cacheTrie.isLeaf = true;
        cacheTrie.url = new String(url);
    }

    public String searchIP(String ipAddress)
    {
        int addressLen = ipAddress.length(),index;
        ReverseDNSCacheTrieNode cacheTrie = getCache();
        for (int i = 0; i < addressLen; i++) {
            index = getCharacterIndex(ipAddress.charAt(i));
            if(cacheTrie.children[index]== null)
                return null;
            cacheTrie = cacheTrie.children[index];
        }
        if(cacheTrie!=null && cacheTrie.isLeaf)
            return cacheTrie.url;
        return null;
    }
}

