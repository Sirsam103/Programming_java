public class Main {

    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        System.out.println("Initial state:");
        System.out.println("Coffee Maker is on: " + myCoffeeMaker.isOn());
        System.out.println("Coffee type: " + myCoffeeMaker.getCoffeeType());
        System.out.println("Coffee amount: " + myCoffeeMaker.getCoffeeAmount());

        System.out.println("\nTurning on the coffee maker...");
        myCoffeeMaker.switchPower();
        System.out.println("Coffee Maker is on: " + myCoffeeMaker.isOn());

        System.out.println("\nSetting coffee type to espresso...");
        myCoffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type: " + myCoffeeMaker.getCoffeeType());

        System.out.println("\nSetting coffee amount to 50 ml...");
        myCoffeeMaker.setCoffeeAmount(50);
        System.out.println("Coffee amount: " + myCoffeeMaker.getCoffeeAmount());

        System.out.println("\nTurning off the coffee maker...");
        myCoffeeMaker.switchPower();
        System.out.println("Coffee Maker is on: " + myCoffeeMaker.isOn());

        System.out.println("\nTrying to set coffee type while off...");
        myCoffeeMaker.setCoffeeType("normal");
        System.out.println("Coffee type: " + myCoffeeMaker.getCoffeeType());

        System.out.println("\nTrying to set coffee amount while off...");
        myCoffeeMaker.setCoffeeAmount(30);
        System.out.println("Coffee amount: " + myCoffeeMaker.getCoffeeAmount());
    }
}
