package geometric;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by neagrawa on 5/15/17.
 */
public class GrahamScanConvexHull extends TestCase {

    private Point p0;

    public int squareDist(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    public Comparator<Point> polarAngleComparator = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            int o = GeometricUtil.getOrientation(p0, p1, p2);
            if (o == 0) return squareDist(p0, p1) <= squareDist(p0, p2) ? -1 : 1;
            return o == -1 ? -1 : 1;
        }
    };

    public List<Point> convexHull(Point[] points) {
        //find the bottommost point
        int n = points.length, min = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < points[min].y || (points[i].y == points[min].y && points[i].x < points[min].x))
                min = i;
        }
        swap(points, 0, min);
        p0 = points[0];
        //sort points taking 0th point as reference
        Arrays.sort(points, 1, n, polarAngleComparator);

        int m = 1; //size of modified array
        for (int i = 1; i < n; i++) {
            while (i < n - 1 && GeometricUtil.getOrientation(p0, points[i], points[i + 1]) == 0) //angle of i & i+1 same wrt p0
                i++;
            points[m++] = points[i];
        }

        if (m < 3) return null; //convex hull not possible
        Stack<Point> s = new Stack<>();
        s.push(points[0]);
        s.push(points[1]);
        s.push(points[2]);

        //process remaining m-3 points
        for (int i = 3; i < m; i++) {
            //keep removing till the angle is a non left turn
            while (!s.isEmpty() && GeometricUtil.getOrientation(GeometricUtil.getNextToTop(s), s.peek(), points[i]) != -1)
                s.pop();
            s.push(points[i]);
        }

        return new ArrayList<>(s);
    }


    public void swap(Point[] a, int i, int j) {
        Point temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void testConvexHull() {
        int[][] points = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        Point[] pointList = GeometricUtil.getPoints(points);
        List<Point> convexHull = convexHull(pointList);
        for (Point p : convexHull)
            System.out.println(p.toString());
    }
}
