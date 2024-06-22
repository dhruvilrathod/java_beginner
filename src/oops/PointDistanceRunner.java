package oops;

public class PointDistanceRunner {

    public static void main(String[] args) {
        PointDistance p1 = new PointDistance(3, 4);
        PointDistance p2 = new PointDistance(6, 8);

        p1.move(1, 1);

        double distance = p1.distanceTo(p2);  // The distance from p1 to p2 should be sqrt((6-4)^2 + (8-5)^2) = sqrt(4+9) = sqrt(13) ≈ 3.60555
    }
}
