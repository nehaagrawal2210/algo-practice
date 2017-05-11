package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/14/2017.
 */
public class MaxShareProfit extends TestCase{

    public int getMaxShareProfit(int a[])
    {
        int maxProfitSoFar=0,diff,min1=a[0],min2,max2ProfitSoFar;
        int maxProfit=0;
        for (int i = 1; i < a.length-1; i++) {
            //max profit 0..i
            if((a[i]>min1) && (a[i]-min1>maxProfitSoFar))
                maxProfitSoFar=a[i]-min1;
            else if(a[i]<min1)
                min1=a[i];
            min2=a[i+1];
            max2ProfitSoFar=0;
            for (int j = i+2; j < a.length; j++) {
                //max profit i+1..n
                if(a[j]<min2)
                    min2=a[j];
                else if(a[j]>min2 && a[j]-min2>max2ProfitSoFar)
                    max2ProfitSoFar=a[j]-min2;
            }
            maxProfit=Math.max(maxProfit,maxProfitSoFar+max2ProfitSoFar);
        }
        return maxProfit;
    }

    public int getMaxShareProfitOptimized(int[] prices,int length)
    {
        int[] profit=new int[length];
        int[] maxProfitSoFar=new int[length];

//        initialize the profits to 0
        for (int i = 0; i < length; i++)
            profit[i]=0;

//        initialize profit i..n in profit[i]
        int maxPrice=prices[length-1];
        for (int i = length-2; i>=0; i--) {
            if(prices[i]>maxPrice)
                maxPrice=prices[i];
            profit[i]=Math.max(profit[i+1],maxPrice-prices[i]);
        }

        int minPrice=prices[0];
        for (int i = 1; i < length; i++) {
            if(prices[i]<minPrice)
                minPrice=prices[i];
            profit[i]=Math.max(profit[i-1],profit[i]+(prices[i]-minPrice));
        }
        return profit[length-1];
    }

    @Test
    public void testGetMaxProfit()
    {
        int price[]={10, 22, 5, 75, 65, 80};
        int price1[]={2, 30, 15, 10, 8, 25, 80};
        int price2[]={100, 30, 15, 10, 8, 25, 80};
        int price3[]={90, 80, 70, 60, 50};
        assertEquals(87,getMaxShareProfit(price));
        assertEquals(100,getMaxShareProfit(price1));
        assertEquals(0,getMaxShareProfit(price3));
        assertEquals(72,getMaxShareProfit(price2));

    }

    @Test
    public void testGetMaxProfitOptimized()
    {
        int price[]={10, 22, 5, 75, 65, 80};
        int price1[]={2, 30, 15, 10, 8, 25, 80};
        int price2[]={100, 30, 15, 10, 8, 25, 80};
        int price3[]={90, 80, 70, 60, 50};
        assertEquals(87,getMaxShareProfitOptimized(price,price.length));
        assertEquals(100,getMaxShareProfitOptimized(price1,price1.length));
        assertEquals(0,getMaxShareProfitOptimized(price3,price3.length));
        assertEquals(72,getMaxShareProfitOptimized(price2,price2.length));

    }
}
