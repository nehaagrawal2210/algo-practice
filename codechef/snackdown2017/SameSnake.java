package codechef.snackdown2017;

/**
 * Created by neagrawa on 5/23/17.
 */
public class SameSnake {
    public static void main(String[] args) throws java.io.IOException{
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        java.util.StringTokenizer st;
        Point p1,p2,p3,p4;
        for (int i = 0; i < testCases; i++) {
            st = new java.util.StringTokenizer(br.readLine());
            p1=  new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
            p2=  new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
            st = new java.util.StringTokenizer(br.readLine());
            p3=  new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
            p4=  new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
            if(isSameSnake(p1,p2,p3,p4)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    public static  boolean isSameSnake(Point p1,Point p2,Point p3,Point p4)
    {
        //if they both lie on same axises i.e either x component or y component will be same for them
        if((p1.x!=p2.x && p1.y!=p2.y) || (p3.x!=p4.x && p3.y!=p4.y)) return false;
        if(p1.x == p2.x && p2.x==p3.x && p3.x==p4.x) return isOverlappingX(p1,p2,p3,p4);
        if(p1.y == p2.y  && p2.y==p3.y && p3.y==p4.y) return isOverlappingY(p1,p2,p3,p4);
        //else only vertices should be same, if they join in middle then degree will be more than 2
        //either p1 should be equal to p3 or p4, or p2 should be equal to p3 or p4
        if(isEqual(p1,p3)||isEqual(p1,p4)||isEqual(p2,p3)||isEqual(p2,p4)) return true;
        return false;
    }

    public static boolean isOverlappingX(Point p1,Point p2,Point p3,Point p4)
    {
        if(p1.y>p2.y)
        {
            Point t = p1;
            p1=p2;
            p2=t;
        }
        if(p3.y>p4.y)
        {
            Point t=p3;
            p3=p4;
            p4=t;
        }
        if(p3.y<=p2.y && p3.y>=p1.y) return true;
        if(p4.y>=p1.y && p4.y<=p2.y) return true;
        return false;
    }

    public static boolean isOverlappingY(Point p1,Point p2,Point p3,Point p4)
    {
        if(p1.x>p2.x)
        {
            Point t = p1;
            p1=p2;
            p2=t;
        }
        if(p3.x>p4.x)
        {
            Point t=p3;
            p3=p4;
            p4=t;
        }
        if(p3.x<=p2.x && p3.x>=p1.x) return true;
        if(p4.x>=p1.x && p4.x<=p2.x) return true;
        return false;
    }

    public static boolean isEqual(Point p1,Point p2)
    {
        return p1.x==p2.x && p1.y==p2.y;
    }

    static class Point{
        long x;
        long y;

        public Point(long x,long y)
        {
            this.x = x;
            this.y = y;
        }

        @Override public String toString() {
            return "(" + x + ","+ y + ')';
        }
    }
}
