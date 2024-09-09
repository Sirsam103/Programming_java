public class Car2 {
    private double gasolineTankCapacity;
    private double topSpeed;
    private double currentSpeed;
    private double fuelLevel;
    private double cruiseControlTarget;
    private boolean cruiseControlOn;
    private final double MIN_CRUISE_SPEED = 30.0;
    private final double MAX_CRUISE_SPEED = 180.0;

    public Car2(String typeName) {
        this(typeName, 50.0, 200.0);
    }

    public Car2(String typeName, double gasolineTankCapacity, double topSpeed) {
        this.gasolineTankCapacity = gasolineTankCapacity;
        this.topSpeed = topSpeed;
        this.currentSpeed = 0;
        this.fuelLevel = gasolineTankCapacity;
        this.cruiseControlTarget = 0;
        this.cruiseControlOn = false;
    }

    public void fillTank() {
        this.fuelLevel = gasolineTankCapacity;
    }

    public void accelerate() {
        if (fuelLevel > 0) {
            if (cruiseControlOn) {
                if (currentSpeed < cruiseControlTarget) {
                    currentSpeed = Math.min(currentSpeed + 10, cruiseControlTarget);
                    fuelLevel -= 0.5;
                } else if (currentSpeed > cruiseControlTarget) {
                    decelerate(currentSpeed - cruiseControlTarget);
                }
            } else {
                currentSpeed = Math.min(currentSpeed + 10, topSpeed);
                fuelLevel -= 0.5;
            }
        }
    }

    public void decelerate(double amount) {
        currentSpeed = Math.max(currentSpeed - amount, 0);
    }

    public double getSpeed() {
        return currentSpeed;
    }

    public String getTypeName() {
        return "Car";
    }

    public double getGasolineTankCapacity() {
        return gasolineTankCapacity;
    }

    public void setGasolineTankCapacity(double gasolineTankCapacity) {
        this.gasolineTankCapacity = gasolineTankCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setCruiseControl(double targetSpeed) {
        if (targetSpeed < MIN_CRUISE_SPEED || targetSpeed > MAX_CRUISE_SPEED) {
            this.cruiseControlOn = false;
        } else {
            this.cruiseControlTarget = targetSpeed;
        }
    }

    public boolean turnCruiseControlOn() {
        if (cruiseControlTarget > 0 && cruiseControlTarget <= topSpeed) {
            cruiseControlOn = true;
            return true;
        } else {
            cruiseControlOn = false;
            return false;
        }
    }

    public void turnCruiseControlOff() {
        cruiseControlOn = false;
    }

    public double getCruiseControlTarget() {
        return cruiseControlTarget;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }
}
