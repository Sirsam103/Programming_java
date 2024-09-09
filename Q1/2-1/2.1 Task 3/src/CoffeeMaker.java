public class CoffeeMaker {
    private boolean isOn;
    private String coffeeType;
    private int coffeeAmount;

    public CoffeeMaker() {
        this.isOn = false;
        this.coffeeType = "normal";
        this.coffeeAmount = 10;
    }

    public void switchPower() {
        this.isOn = !this.isOn;
    }

    public void setCoffeeType(String type) {
        if (isOn) {
            if (type.equals("normal") || type.equals("espresso")) {
                this.coffeeType = type;
            }
        }
    }

    public void setCoffeeAmount(int amount) {
        if (isOn) {
            if (amount >= 10 && amount <= 80) {
                this.coffeeAmount = amount;
            }
        }
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public boolean isOn() {
        return isOn;
    }
}
