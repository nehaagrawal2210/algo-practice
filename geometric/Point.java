package geometric;

/**
 * Created by neagrawa on 5/15/17.
 */
public class Point {
        int x;
        int y;
        public Point(int x,int y)
        {
            this.x = x;
            this.y = y;
        }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
