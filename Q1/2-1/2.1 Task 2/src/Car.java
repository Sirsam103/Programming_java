public class Car {
    private double gasolineTankCapacity;
    private double topSpeed;
    private double currentSpeed;
    private double fuelLevel;

    public Car(String typeName) {
        this(typeName, 50.0, 200.0);
    }

    public Car(String typeName, double gasolineTankCapacity, double topSpeed) {
        this.gasolineTankCapacity = gasolineTankCapacity;
        this.topSpeed = topSpeed;
        this.currentSpeed = 0;
        this.fuelLevel = gasolineTankCapacity;
    }

    public void fillTank() {
        this.fuelLevel = gasolineTankCapacity;
    }

    public void accelerate() {
        if (fuelLevel > 0) {
            currentSpeed = Math.min(currentSpeed + 10, topSpeed);
            fuelLevel -= 0.5;
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
}
