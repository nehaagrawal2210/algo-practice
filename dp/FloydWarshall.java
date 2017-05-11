package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/10/2017.
 */
public class FloydWarshall extends TestCase{

    public static final int INF=Integer.MAX_VALUE;

    public void getShortestPath(int graph[][])
    {
        int len=graph.length,i,j,k;
        int[][] shortest=new int[len][len];

        for (i = 0; i <len ; i++) {
            for (j = 0; j <len ; j++) {
                shortest[i][j]=graph[i][j];
            }
        }

        //k is intermediate vertice
        for (k = 0; k < len ; k++) {
            //source vertice
            for (i = 0; i < len ; i++) {
                //destination vertice
                for (j = 0; j < len; j++) {
                    if(shortest[i][k]!=INF && shortest[k][j]!=INF && shortest[i][k]+shortest[k][j] < shortest[i][j])
                        shortest[i][j]=shortest[i][k]+shortest[k][j];
                }
            }
        }
        printSolution(shortest);
    }

    public void printSolution(int[][] graph)
    {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j]==INF)
                    System.out.print("INF ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testGetShortestPath()
    {
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        getShortestPath(graph);
    }
}
