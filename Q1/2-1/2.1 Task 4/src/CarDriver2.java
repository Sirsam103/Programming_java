public class CarDriver2 {

    public static void main(String[] args) {
        Car2 myCar;

        myCar = new Car2("Toyota Corolla", 50.0, 200.0);
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.setCruiseControl(80);
        if (myCar.turnCruiseControlOn()) {
            System.out.println("Cruise control is on. Target speed is " + myCar.getCruiseControlTarget() + " km/h");
        } else {
            System.out.println("Unable to set cruise control.");
        }

        for (int i = 0; i < 10; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
            if (myCar.getSpeed() >= myCar.getCruiseControlTarget()) {
                myCar.decelerate(0);
                System.out.println("Cruise control maintaining target speed.");
            }
        }

        myCar.turnCruiseControlOff();
        System.out.println("Cruise control is off.");
    }
}
