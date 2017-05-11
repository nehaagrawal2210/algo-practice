package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by neha on 10/7/2016.
 */
public class TowerOfHanoi {

    Stack<Integer> source, aux, dest;
    char sourceCode = 'S';
    char auxCode = 'A';
    char destCode = 'D';

    TowerOfHanoi(int disks)
    {
        source = new Stack<Integer>();
        aux  = new Stack<Integer>();
        dest  = new Stack<Integer>();

        //fill the source minStack
        for(int i = disks; i>0; i--)
            source.push(i);
    }

    public void moveDisk(int diskNo, char source, char dest)
    {
        System.out.println("Move the disk "+diskNo+" from disk "+ source+" to disk "+dest);
    }

    public void makeLegalMove(Stack<Integer> source, Stack<Integer> desti, char s, char d)
    {
        if(source.isEmpty())
        {
            int destTopDisk = desti.pop();
            source.push(destTopDisk);
            moveDisk(destTopDisk,d,s);
        }
        else if(desti.isEmpty())
        {
            int sourceTopDisk = source.pop();
            desti.push(sourceTopDisk);
            moveDisk(sourceTopDisk,s,d);
        }

        else
        {
            int destTopDisk = desti.pop();
            int sourceTopDisk = source.pop();

            if(destTopDisk < sourceTopDisk)
            {
                source.push(sourceTopDisk);
                source.push(destTopDisk);
                moveDisk(destTopDisk,d,s);
            }

            else
            {
                desti.push(destTopDisk);
                desti.push(sourceTopDisk);
                moveDisk(sourceTopDisk,s,d);
            }
        }
    }

    public void solveTowerOfHanoiIterative(int n)
    {
        if(n%2 == 0)
        {
            //Even no, exchange aux and destination
            char temp =auxCode;
            auxCode = destCode;
            destCode = temp;
        }

        //Make moves according to disk no
        int moves = (int) Math.pow(2,n) -1;

        for(int i=1;i<=moves;i++)
        {
            if(i%3 == 1)
            {
                makeLegalMove(source,dest,sourceCode,destCode);
            }
            else if(i%3 == 2)
            {
                makeLegalMove(source,aux,sourceCode,auxCode);
            }
            else if(i%3 == 0)
            {
                makeLegalMove(aux,dest,auxCode,destCode);
            }
        }

    }

    public static void main(String args[]) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(isr);

        System.out.println("Enter no of disks-------");
        int disks = Integer.parseInt(r.readLine());
        TowerOfHanoi h = new TowerOfHanoi(disks);

        h.solveTowerOfHanoiIterative(disks);
    }
}
