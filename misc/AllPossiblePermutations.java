package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neha on 1/31/2017.
 */
public class AllPossiblePermutations {

    public static void printAllPossibleCombRec(String prefix, String s,List<String> perms)
    {
        int l= s.length();
        if(l==0)
        {
            System.out.println(prefix);
            perms.add(prefix);
        }
        else
            for (int i = 0; i < l; i++) {
                printAllPossibleCombRec(prefix+s.substring(i,i+1),s.replace(s.substring(i,i+1),""),perms);
            }
    }

/*
    public static void printAllPossibleCombRec(String s)
    {
        printAllPossibleCombRec("",s);
    }
*/

    public static void printAllPossibleCombItr(String s)
    {
        String aux;
        int len=s.length();
        int factorial=fact(len-1);
        int c=0;
        for (int k=1;k<=s.length();k++) {
            aux=s;
            for (int i = 0; i <factorial ;) {
                for (int j = 1; j < len-1; j++) {
                    aux=swapChar(aux,j,j+1);
                    i++;
                    c++;
                    System.out.println(aux);
                }
            }
            if(k==len) break;
            s=swapChar(s,0,k);
        }
        System.out.println("Count= "+c);
    }

    public static String swapChar(String s,int i,int j)
    {
        char c[]=s.toCharArray();

        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;

        return new String (c);
    }

    public static int fact(int m)
    {
        int fac=1;
        for (int i = 2 ; i <=m ; i++) {
            fac*=i;
        }
        return fac;
    }

    public static void main(String[] args) {
//        printAllPossibleCombRec("acdef");
//        printAllPossibleCombItr("xyz");
//        printAllPossibleCombItr("abcde");
        List<String> perms  = new ArrayList<>();
        printAllPossibleCombRec("","abc",perms);
        System.out.println(perms.toString());
    }
}
