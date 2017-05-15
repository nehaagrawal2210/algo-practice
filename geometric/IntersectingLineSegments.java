package geometric;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/15/17.
 * http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 */
public class IntersectingLineSegments extends TestCase {

    class Point{
        int x;
        int y;
        public Point(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public int getOrientation(Point p,Point q,Point r)
    {
        int value = (q.y-p.y)*(r.x-q.x) - (r.y-q.y)*(q.x-p.x);
        if(value == 0) return 0; //collinear
        if(value<0) return -1; //counterclockwise
        else return 1; //clockwise
    }

    public boolean onSegment(Point p,Point q,Point r) //checks if q lies on segment PR
    {
        if(q.x<= Math.max(p.x,r.x) && q.x>=Math.min(p.x,r.x)
                && q.y<= Math.max(p.y,r.y) && q.y>=Math.min(p.y,r.y))
            return true;
        return false;
    }

    public boolean doesIntersect(Point p1, Point q1, Point p2, Point q2)
    {
        int o1 = getOrientation(p1,q1,p2);
        int o2 = getOrientation(p1,q1,q2);
        int o3 = getOrientation(p2,q2,p1);
        int o4 = getOrientation(p2,q2,q1);
        if(o1!=o2 && o3!=o4) return true; //first case where orientations are different
        //case for collinear points

        if((o1 == 0 && onSegment(p1,p2,q1))
            || (o2 == 0 && onSegment(p1,q2,q1))
            || (o3 == 0 && onSegment(p2,p1,q2))
            || (o4 == 0 && onSegment(p2,q1,q2)))
            return true;
        return false;
    }

    public void testDoesIntersect()
    {
        Point p1 = new Point(1,1);
        Point q1 = new Point(10,1);
        Point p2 = new Point(1,2);
        Point q2 = new Point(10,2);
        assertFalse(doesIntersect(p1,q1,p2,q2));

        p1 = new Point(10,0);
        q1 = new Point(0,10);
        p2 = new Point(0,0);
        q2 = new Point(10,10);
        assertTrue(doesIntersect(p1,q1,p2,q2));

        p1 = new Point(-5,-5);
        q1 = new Point(0,10);
        p2 = new Point(1,1);
        q2 = new Point(10,10);
        assertFalse(doesIntersect(p1,q1,p2,q2));
    }
}
