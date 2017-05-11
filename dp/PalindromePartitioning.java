package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/10/2017.
 */
public class PalindromePartitioning extends TestCase{

    public int getMinCutsRec(String s, int i, int j)
    {
        if(i==j) return 0; //one character, no cuts required
        if(isPalindrome(s,i,j)) return 0; //Palindrome string no cuts required

        //find all cuts possible
        int minCuts=Integer.MAX_VALUE,cuts;
        for (int k = i; k < j; k++) {
            cuts= getMinCutsRec(s,i,k)+ getMinCutsRec(s,k+1,j)+1;
            if(cuts<minCuts)
                minCuts=cuts;
        }
        return minCuts;
    }

    public int getMinCutsDP(String s,int l)
    {
        int count[][]=new int[l][l];
        boolean isPal[][]=new boolean[l][l];

        for (int i = 0; i < l; i++) {
            count[i][i]=0; //single character always palindrome, no cuts required
            isPal[i][i]=true; //single character always palindrome
        }

        int L,i,j,k;
        //length of substring 2 to l
        for (L = 2; L <= l; L++) {
            //starting indexes of substring
            for (i = 0; i < l-L+1; i++) {
                j=i+L-1; //last index
                if(L==2)
                    isPal[i][j]=(s.charAt(i)==s.charAt(j));
                else
                    isPal[i][j]= (s.charAt(i)==s.charAt(j)) && isPal[i+1][j-1];
                if(isPal[i][j])
                    count[i][j]=0;
                else {
                    count[i][j]=Integer.MAX_VALUE;
                    for (k = i; k < j; k++) {
                        count[i][j]=Math.min(count[i][j],count[i][k]+count[k+1][j]+1);
                    }
                }
            }
        }
        return count[0][l-1];
    }

    public int getMinCuts(String s,int l)
    {
        boolean isPal[][]=new boolean[l][l];
        int c[]=new int[l];

        for (int i = 0; i < l; i++) {
            isPal[i][i]=true;
        }

        int L,i,j;
        for (L = 2; L <=l ; L++) {
            for (i = 0; i < l-L+1; i++) {
                j=i+L-1;
                if(L==2) isPal[i][j]=(s.charAt(i)==s.charAt(j));
                else isPal[i][j]=(s.charAt(i)==s.charAt(j)) && isPal[i+1][j-1];
            }
        }

        for (i=0; i<l; i++)
        {
            if (isPal[0][i])
                c[i] = 0;
            else
            {
                c[i]= Integer.MAX_VALUE;
                for(j=0;j<i;j++)
                {
                    if(isPal[j+1][i] && 1+c[j]<c[i])
                        c[i]=1+c[j];
                }
            }
        }
        return c[l-1];
    }

    public boolean isPalindrome(String s,int i,int j)
    {
        while (i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    @Test
    public void testIsPalindrome()
    {
        String s="acca";
        String s1="acdca";
        String s2="acdica";
        assertEquals(true,isPalindrome(s,0,3));
        assertEquals(true,isPalindrome(s1,0,4));
        assertEquals(false,isPalindrome(s2,0,5));
    }

    @Test
    public void testGetMinCutsRec()
    {
        String s="ababbbabbababa";
        assertEquals(3,getMinCutsRec(s,0,s.length()-1));
    }

    @Test
    public void testGetMinCutsDP()
    {
        String s="aclcbaba";
        assertEquals(3,getMinCutsDP(s,s.length()));
    }

    @Test
    public void testGetMinCuts()
    {
        String s="aclcbaba";
        assertEquals(3,getMinCuts(s,s.length()));
    }
}
