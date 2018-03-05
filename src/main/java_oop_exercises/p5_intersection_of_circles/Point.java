package p5_intersection_of_circles;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }

    public static double distanceBetweenPoint(Point a, Point b){
        int sideA = a.x - b.x;
        int sideB = a.y - b.y;

        return Math.sqrt(sideA*sideA + sideB*sideB);
    }
}
