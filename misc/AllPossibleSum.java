package misc;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by neha on 2/5/2017.
 */
public class AllPossibleSum extends TestCase{

    public void getAllPossibleSum(List<Integer> a,List<Integer> partial,int targetSum)
    {
        int l=a.size();
        int partialSum = partial.stream().mapToInt(i->i).sum();

        if(partialSum==targetSum)
        {
            System.out.println(partial.toString());
            return;
        }

        if(l==0 || partialSum>targetSum)
            return;

        for (int i = 0; i < l; i++) {

            List<Integer> remainingIntegers = new ArrayList<>(a.subList(i+1,a.size()));
            List<Integer> partialInt=new ArrayList<>(partial);
            partialInt.add(a.get(i));
            getAllPossibleSum(remainingIntegers,partialInt,targetSum);
        }
    }


    @Test
    public void testGetAllPossibleSum()
    {
        Integer[] a={3,9,8,4,5,7,10};
        int targetSum=15;
        getAllPossibleSum(new ArrayList<Integer>(Arrays.asList(a)),new ArrayList<Integer>(),targetSum);
    }
}
