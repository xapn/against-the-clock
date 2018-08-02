public class AgainstTheClock {

    public void start(AutonomousCar car) {
        car
                .getBattery()
                .charge();
        if (!car.fillUpTheFuelTank(100)) {
            throw new IllegalStateException(
                    "Can't start an autonomous car without " + "having filled up the fuel tank capacity");
        }
        car.turnOnPowerButton();
        car.startAutomaticDriving();
    }
}