package practice;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neagrawa on 5/29/17.
 */
public class RotOranges extends TestCase {
    class Elem{
        int x;
        int y;
        public Elem(int x,int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Elem elem = (Elem) o;

            if (x != elem.x)
                return false;
            return y == elem.y;
        }

        @Override public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    public int timeToRot(int[][] oranges)
    {
        int ans = 0;
        int R = oranges.length;
        int C = oranges[0].length;
        Queue<Elem> queue = new LinkedList<>();
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if(oranges[i][j]==2)
                    queue.add(new Elem(i,j));
            }
        }
        Elem delimiter = new Elem(-1,-1),temp;
        queue.add(delimiter);
        while (!queue.isEmpty())
        {
            boolean didRot = false;
            while (!queue.peek().equals(delimiter))
            {
                temp = queue.poll();

                //rot right adjacent cell
                if(isValid(temp.x,temp.y+1,R,C) && oranges[temp.x][temp.y+1] == 1)
                {
                    oranges[temp.x][temp.y+1]=2;
                    if(!didRot) {
                        didRot=true;
                        ans++;
                    }
                    queue.add(new Elem(temp.x,temp.y+1));
                }
                //left cell
                if(isValid(temp.x,temp.y-1,R,C) && oranges[temp.x][temp.y-1] == 1)
                {
                    oranges[temp.x][temp.y-1]=2;
                    if(!didRot) {
                        didRot=true;
                        ans++;
                    }
                    queue.add(new Elem(temp.x,temp.y-1));
                }
                //down cell
                if(isValid(temp.x+1,temp.y,R,C) && oranges[temp.x+1][temp.y] == 1)
                {
                    oranges[temp.x+1][temp.y]=2;
                    if(!didRot) {
                        didRot=true;
                        ans++;
                    }
                    queue.add(new Elem(temp.x+1,temp.y));
                }
                if(isValid(temp.x-1,temp.y,R,C) && oranges[temp.x-1][temp.y] == 1)
                {
                    oranges[temp.x-1][temp.y]=2;
                    if(!didRot) {
                        didRot=true;
                        ans++;
                    }
                    queue.add(new Elem(temp.x-1,temp.y));
                }
            }
            queue.poll(); //remove delimiter
            if(!queue.isEmpty())
            {
                queue.add(delimiter);
            }
        }
        return checkALL(oranges)?ans:-1;
    }

    public boolean checkALL(int[][] oranges)
    {
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if(oranges[i][j] == 1) return false;
            }
        }
        return true;
    }

    public boolean isValid(int i,int j,int R,int C)
    {
        return i>=0 && j>=0 && i<R && j<C;
    }

    public void testRot()
    {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}
                      };
        assertEquals(2,timeToRot(arr));
    }
}
