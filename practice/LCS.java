package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/3/17.
 */
public class LCS extends TestCase{
    public int lcsLen(String s1,String s2,int n1, int n2,int lcs[][])
    {
        if(n1 == 0 || n2 == 0) return 0;
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            if(lcs[n1-1][n2-1] ==-1)
                lcs[n1-1][n2-1] = lcsLen(s1,s2,n1-1,n2-1,lcs);
            return 1+lcs[n1-1][n2-1];
        }
        if(lcs[n1-1][n2]==-1)
            lcs[n1-1][n2] = lcsLen(s1,s2,n1-1,n2,lcs);
        if(lcs[n1][n2-1] == -1)
            lcs[n1][n2-1] = lcsLen(s1,s2,n1,n2-1,lcs);
        return Math.max(lcs[n1-1][n2],lcs[n1][n2-1]);
    }

    public int lcsLen(String s1, String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int lcs[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                lcs[i][j]=-1;
            }
        }
        return lcsLen(s1,s2,n1,n2,lcs);
    }

    public int[][] lcsLenDP(String s1, String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] lcs = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if(i==0 || j==0) lcs[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    lcs[i][j]=1+lcs[i-1][j-1];
                else
                    lcs[i][j]= Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        return lcs;
    }

    public void printLCS(String s1,String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] lcs = lcsLenDP(s1,s2);
        int i=n1,j=n2;
        String res="";
        while (i>0 && j>0)
        {
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                res+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(lcs[i-1][j]>lcs[i][j-1])
                i--;
            else j--;
        }
        System.out.println("LCS= "+res);
    }

    public void testLcsLen()
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcsLen(s1,s2));
        printLCS(s1,s2);
    }
}
