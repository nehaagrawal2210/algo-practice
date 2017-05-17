package leetcode;

import geometric.GeometricUtil;
import geometric.Point;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by neagrawa on 5/15/17.
 * Jarvis March Algorithm
 */
public class ErectTheFence extends TestCase {

    public List<Point> outerTrees(Point[] points)
    {
        int n = points.length;
        if(n<=3) return Arrays.asList(points); //we need at least 3 points

        List<Point> convexHullPoints= new ArrayList<>();

        //Find the leftmost x point
        int l=0;
        for (int i = 1; i < n; i++) {
            if(points[i].getX() < points[l].getX()) l=i;
        }

        int p=l,q;
        do{
            q=(p+1)%n; //set next point as q
            for (int i = 0; i < n; i++) {
                if(i==p)continue;
                int orientation = GeometricUtil.getOrientation(points[p],points[i],points[q]);
                if(orientation == -1
                        || (orientation == 0 && GeometricUtil.getSquareDist(points[p],points[i])>GeometricUtil.getSquareDist(points[p],points[q])))
                    q=i;
            }
            for (int i = 0; i < n; i++) {
                if(i==p)continue;
                if(GeometricUtil.getOrientation(points[p],points[i],points[q])==0)
                    convexHullPoints.add(points[i]);
            }
            p=q;
        } while (p!=l);
        return convexHullPoints;
    }

    public void testGetConvexHull()
    {
        int[][] points= {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        Point[] pointList = GeometricUtil.getPoints(points);
        List<Point> convexHull = outerTrees(pointList);
        for (Point p: convexHull)
            System.out.print(p.toString()+", ");

        System.out.println();
        int[][] points1 = {{5,5},{4,8},{1,3},{5,9},{3,0},{0,4},{3,2},{8,9},{9,3}};
        pointList = GeometricUtil.getPoints(points1);
        convexHull = outerTrees(pointList);
        for (Point p: convexHull)
            System.out.print(p.toString()+", ");
    }
}
