package oops;

public class MotorBikeRunner {

    public static void main(String[] args) {
        MotorBike ducati = new MotorBike(10);
        MotorBike honda = new MotorBike();

        ducati.start();
        honda.start();

//        honda.setSpeed(100);
        honda.increaseSpeed(200);
        honda.decreaseSpeed(50);
        System.out.println(ducati.getSpeed());
        System.out.println(honda.getSpeed());
    }

}
