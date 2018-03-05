package p5_intersection_of_circles;

public class Circle {
    private Point point;
    private int r;

    public Circle(int x, int y, int r) {
        this.r = r;
        this.point = new Point(x,y);
    }

    public static String isIntersect(Circle a, Circle b){
        double distance = Point.distanceBetweenPoint(a.point,b.point);
        int totalRadiuses = a.r + b.r;

        if (distance > totalRadiuses){
            return "No";
        } else
            return "Yes";
    }
}
