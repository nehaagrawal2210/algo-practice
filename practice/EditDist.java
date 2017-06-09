package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/3/17.
 */
public class EditDist extends TestCase {
    public int editDistRec(String s1, String s2,int n1,int n2)
    {
        if(n1 ==0) return n2;
        if(n2 == 0) return n1;
        if(s1.charAt(n1-1) == s2.charAt(n2-1))
            return editDistRec(s1,s2,n1-1,n2-1);
        return 1+
                Math.min(editDistRec(s1,s2,n1,n2-1), //insert in s1
                Math.min(editDistRec(s1,s2,n1-1,n2), //remove
                        editDistRec(s1,s2,n1-1,n2-1))); //replace
    }

    public int editDistDP(String s1,String s2)
    {
        int m = s1.length();
        int n = s2.length();
        int lcs[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0) lcs[i][j]=j;
                else if(j==0) lcs[i][j]=i;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    lcs[i][j]=lcs[i-1][j-1];
                else{
                    lcs[i][j]= 1+ Math.min(lcs[i][j-1],Math.min(lcs[i-1][j],lcs[i-1][j-1]));
                }
            }
        }
        return lcs[m][n];
    }

    public void testEditDistRec()
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistRec(str1,str2,str1.length()-1,str2.length()-1));
        System.out.println(editDistDP(str1,str2));
    }
}
