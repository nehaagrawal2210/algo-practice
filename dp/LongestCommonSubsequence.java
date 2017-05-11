package dp;

/**
 * Created by neha on 1/31/2017.
 */
public class LongestCommonSubsequence {

    public static int lcsLenRec(String s, String s1)
    {
        int m=s.length();
        int n=s1.length();

        if(m==0 || n==0)
            return 0;
        if(s.charAt(m-1)==s1.charAt(n-1))
        {
            return 1+ lcsLenRec(s.substring(0,m-1),s1.substring(0,n-1));
        }
        else
            return Math.max(lcsLenRec(s.substring(0,m-1),s1), lcsLenRec(s,s1.substring(0,n-1)));
    }

    public static int[][] lcsLenDP(String s,String s1)
    {
        int m=s.length();
        int n=s1.length();

        int lcs[][]=new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if(i==0 || j==0)
                    lcs[i][j]=0;
                else if(s.charAt(i-1)==s1.charAt(j-1))
                    lcs[i][j]=1+lcs[i-1][j-1];
                else
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        return lcs;
    }

    public static String printLcs(String s,String s1)
    {
        int lcsLen[][]=lcsLenDP(s,s1);
        int m=s.length();
        int n=s1.length();
        StringBuilder lcs=new StringBuilder();

        int i=m,j=n;
        while (i>0 && j>0)
        {
            if(s.charAt(i-1)==s1.charAt(j-1))
            {
                lcs.append(s.charAt(i-1));
                i--;
                j--;
            }
            else if(lcsLen[i-1][j]>lcsLen[i][j-1])
                i--;
            else
                j--;
        }
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(lcsLenRec("AGGTAB","GXTXAYB"));
//        System.out.println();
        System.out.println(printLcs("AGGTAB","GXTXAYB"));
        System.out.println(printLcs("MZJAWXU","XMJYAUZ"));
        System.out.println(printLcs("ABCDGH","AEDFHR"));
    }
}
