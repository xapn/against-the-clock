public class AgainstTheClock {

    public void start(AutonomousCar car, Fuel fuel) {
        car.prepareBeforeRace(fuel);
        car.startAutomaticDriving();
    }
}