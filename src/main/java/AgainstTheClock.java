public class AgainstTheClock {

    public void start(AutonomousCar car, int fuelQuantity) {
        car.prepareBeforeRace(fuelQuantity);
        car.startAutomaticDriving();
    }
}