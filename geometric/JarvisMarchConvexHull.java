package geometric;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neagrawa on 5/15/17.
 * Jarvis March Algorithm
 */
public class JarvisMarchConvexHull extends TestCase {
    public List<Point> convexHull(Point[] points)
    {
        int n = points.length;
        if(n<3) return null; //we need at least 3 points

        List<Point> convexHullPoints= new ArrayList<>();
        
        //Find the leftmost x point
        int l=0;
        for (int i = 1; i < n; i++) {
            if(points[i].x < points[l].x) l=i;
        }

        int p=l,q;
        do{
            convexHullPoints.add(points[p]);
            q=(p+1)%n; //set next point as q
            for (int i = 0; i < n; i++) {
                if(GeometricUtil.getOrientation(points[p],points[i],points[q]) == -1) q=i;
            }
            p=q;
        } while (p!=l);
        return convexHullPoints;
    }

    public void testGetConvexHull()
    {
        int[][] points= {{0, 3}, {2, 2}, {1, 1}, {2, 1}, {3, 0}, {0, 0}, {3, 3}};
        Point[] pointList = GeometricUtil.getPoints(points);
        List<Point> convexHull = convexHull(pointList);
        for (Point p: convexHull)
            System.out.println(p.toString());
    }
}
