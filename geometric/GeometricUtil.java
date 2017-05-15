package geometric;

/**
 * Created by neagrawa on 5/15/17.
 */
public class GeometricUtil {
    public static int getOrientation(Point p,Point q,Point r)
    {
        int value = (q.y-p.y)*(r.x-q.x) - (r.y-q.y)*(q.x-p.x);
        if(value == 0) return 0; //collinear
        if(value<0) return -1; //counterclockwise
        else return 1; //clockwise
    }

    public static boolean onSegment(Point p,Point q,Point r) //checks if q lies on segment PR
    {
        if(q.x<= Math.max(p.x,r.x) && q.x>=Math.min(p.x,r.x)
                && q.y<= Math.max(p.y,r.y) && q.y>=Math.min(p.y,r.y))
            return true;
        return false;
    }

    public static Point[] getPoints(int[][] points)
    {
        Point[] pointList = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointList[i] = new Point(points[i][0],points[i][1]);
        }
        return pointList;
    }
}
