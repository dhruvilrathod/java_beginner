package oops;

public class MotorBike {

    private int speed;

    MotorBike() {
        this(5);
    }

    MotorBike(int initialSpeed) {
        this.setSpeed(initialSpeed);
    }

    void start() {
        System.out.println("bike started");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed > -1) {
            this.speed = speed;
        } else {
            this.speed = 0;
        }
    }

    public void increaseSpeed(int howMuch) {
        this.speed += howMuch;
    }

    public void decreaseSpeed(int howMuch) {
        this.speed -= howMuch;
        this.setSpeed(this.speed);
    }
}
