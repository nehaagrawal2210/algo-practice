package misc;

import linkedList.DoubleLinkNode;
import linkedList.DoubleLinkedList;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neha on 2/20/2017.
 */
public class LRUCache extends TestCase {

    private final int cacheSize;
    private DoubleLinkedList<Integer> pageList;
    private Map<Integer, DoubleLinkNode> pageMap;
    private int currentSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoubleLinkedList<>();
        pageMap = new HashMap<>();
        currentSize = 0;
    }

    public static void main(String[] args) {

        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);

        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }

    public void accessPage(int pageNumber) {
        if (pageMap.containsKey(pageNumber)) {
            //get it from pageList & move to front of the queue
            DoubleLinkNode page = pageMap.get(pageNumber);
            pageList.moveNodeToHead(page);
        } else {
            //if not present add to map, & size is not maximum then add to map & queue
            if (currentSize == cacheSize) //cache full
            {
                //remove LRU from map & queque
                DoubleLinkNode lruNode = pageList.getTail();
                pageMap.remove(lruNode.getData());
                pageList.removeTail();
                currentSize--;
            }
            //add new page
            DoubleLinkNode newPage = pageList.addNodeToHead(pageNumber);
            pageMap.put(pageNumber, newPage);
            currentSize++;
        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }
}
