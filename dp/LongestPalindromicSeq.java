package dp;

/**
 * Created by neha on 2/1/2017.
 */
//http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
public class LongestPalindromicSeq {

    public static int getLongestPalindromeSeq(String s,int i,int j)
    {
        if(i>j) //no character exists
            return 0;
        if(i==j)   //length 1 is always palindromic
            return 1;
        if((i+1==j) && s.charAt(i)==s.charAt(j)) //length is 2
            return 2;
        if(s.charAt(i)==s.charAt(j))
            return getLongestPalindromeSeq(s,i+1,j-1)+2;
        return Math.max(getLongestPalindromeSeq(s,i+1,j),getLongestPalindromeSeq(s,i,j-1));
    }

    public static int getLongestPalindromeSeqDP(String s)
    {
        int n=s.length(),j;
        int lps[][]=new int[n][n];

        for (int i = 0; i < n; i++) {
            lps[i][i]=1;
        }

        for(int cl=2;cl<=n;cl++)
        {
            for (int i = 0; i <n-cl+1 ; i++) {
                j=i+cl-1;
                if(s.charAt(i)==s.charAt(j) && cl==2)
                    lps[i][j]=2;
                else if(s.charAt(i)==s.charAt(j))
                    lps[i][j]=lps[i+1][j-1]+2;
                else
                    lps[i][j]=Math.max(lps[i+1][j],lps[i][j-1]);
            }
        }
        return lps[0][n-1];
    }

    public static void printLPS(String s)
    {
        String lps=LongestCommonSubsequence.printLcs(s,new StringBuilder(s).reverse().toString());
        System.out.println(lps);
    }

    public static void main(String[] args) {
        String s="GEEKSFORGEEKS";
        System.out.println(getLongestPalindromeSeq(s,0,s.length()-1));
        System.out.println(getLongestPalindromeSeqDP(s));
        printLPS(s);
        printLPS("GEEKS FOR GEEKS");
    }
}
