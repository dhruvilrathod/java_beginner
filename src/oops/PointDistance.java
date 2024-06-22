package oops;

public class PointDistance {
    // x-coordinate of the point
    private int x;

    // y-coordinate of the point
    private int y;

    // Constructor for the Point class
    public PointDistance(int x, int y) {
        this.x = x;  // Assigning x-coordinate of the point
        this.y = y;  // Assigning y-coordinate of the point
    }

    // Method to get the x-coordinate of the point
    public int getX() {
        return x;
    }

    // Method to get the y-coordinate of the point
    public int getY() {
        return y;
    }

    // TODO: Implement the method to move the point by dx and dy in x and y direction respectively
    public void move(int dx, int dy) {
        // Your code here
        this.x += dx;
        this.y += dy;
    }

    // TODO: Implement the method to calculate the distance from this point to another point
    public double distanceTo(PointDistance other) {
        return Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2));
    }
}
