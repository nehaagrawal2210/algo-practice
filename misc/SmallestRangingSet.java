package misc;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by neha on 3/4/2017.
 */
//http://stackoverflow.com/questions/33470036/given-a-set-of-ranges-s-and-an-overlapping-range-r-find-the-smallest-subset-in
class Range{

    int startRange;
    int endRange;

    public static Comparator<Range> StartRangeComparator =  new Comparator<Range>() {
        @Override
        public int compare(Range o1, Range o2) {
            if(o1.startRange == o2.startRange)
            {
                return o1.endRange - o2.endRange;
            }
            return o1.startRange - o2.startRange;
        }
    };

    public Range(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public String toString() {
        return "Range{" +
                "startRange=" + startRange +
                ", endRange=" + endRange +
                '}';
    }

    public boolean doesOverlap(int currBestNum)
    {
        return (startRange <= currBestNum);
    }
}

public class SmallestRangingSet extends TestCase {

    public List<Range> getSmallestRange(Range[] ranges, Range targetRange)
    {
        Arrays.sort(ranges,Range.StartRangeComparator);
        int rangeLen = ranges.length;
        int currBestNum = targetRange.startRange;
        List<Range> rangeCandidate = new ArrayList<>();
        boolean currBestAltered;

        for (int i = 0; i < rangeLen; i++) {
            if(currBestNum >= targetRange.endRange)
                break;
            currBestAltered = false;
            //get max best interval
            while (i<rangeLen && ranges[i].startRange<=currBestNum) {
                i++;
                if(!currBestAltered)currBestAltered = true;
            }
            if(currBestAltered)i--; //to go back to previous interval
            if(ranges[i].doesOverlap(currBestNum)){
                rangeCandidate.add(ranges[i]);
                currBestNum = ranges[i].endRange;
            }
            else break;
        }

        if(currBestNum >= targetRange.endRange)
            return rangeCandidate;
        else  return null;
    }

    @Test
    public void testDisplaySmallestRange()
    {
        int [][] rangesArr = {{1,4},{30,40},{20,91},{8,10},{6,7},{3,9},{9,12},{11,14}};
        Range[] ranges = new Range[8];

        int [][] ranges1Arr = {{1,4},{6,7},{3,5},{4,6},{3,6}};
        Range[] ranges1 = new Range[5];

        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = new Range(rangesArr[i][0],rangesArr[i][1]);
        }

        for (int i = 0; i < ranges1.length; i++) {
            ranges1[i] = new Range(ranges1Arr[i][0],ranges1Arr[i][1]);
        }

//        Range targetRange = new Range(1,7);
//        getSmallestRange(ranges1,targetRange);

        assertEquals(null,getSmallestRange(ranges,new Range(0,7)));
    }
}
