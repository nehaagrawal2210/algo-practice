package array;

import junit.framework.TestCase;

import java.util.*;

/**
 * Created by neagrawa on 5/14/17.
 */
public class KillProcess extends TestCase {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> parentMap = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> children = parentMap.getOrDefault(ppid.get(i),new ArrayList<>());
            children.add(pid.get(i));
            parentMap.put(ppid.get(i),children);
        }

        //now we have parent children map
        //start will killed process and add to queue
        List<Integer> result = new ArrayList<>();
        Queue<Integer> killPidQueue = new LinkedList<>();
        killPidQueue.add(kill);

        List<Integer> children;
        while (!killPidQueue.isEmpty())
        {
            Integer killPid = killPidQueue.poll();
            result.add(killPid);
            children = parentMap.get(killPid);
            if(children!=null)for (Integer child: children) killPidQueue.add(child);
        }
        return result;
    }

    public void testKillProcess()
    {
        Integer[] pid={1,3,10,5};
        Integer[] ppid={3,0,5,3};
        int kill = 5;
        List<Integer> res = new ArrayList<>();
        res.add(5);
        res.add(10);
        assertEquals(res,killProcess(Arrays.asList(pid),Arrays.asList(ppid),kill));
        List<Integer> result  = killProcess(Arrays.asList(pid),Arrays.asList(ppid),kill);
        for (Integer r:result) System.out.print(r+", ");
    }
}
