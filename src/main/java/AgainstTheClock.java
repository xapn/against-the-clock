public class AgainstTheClock {

    public void start(AutonomousCar car) {
        car.getBattery().charge();
        if (!car.fillUpTheFuelTank(100))
            throw new IllegalStateException("Can't start an autonomous car without " +
                    "having filled up the fuel tank capacity");
        car.turnOnPowerButton();
        car.startAutomaticDriving();
    }
}


class AutonomousCar {

    private static final int fuelTankCapacity = 100;
    private int fuelQuantity;
    private boolean poweredOn;
    private final Battery battery;

    public AutonomousCar(Battery battery) {
        this.battery = battery;
    }

    public boolean fillUpTheFuelTank(int fuelQuantity) {
        if (canEntirelyFillUpTheFuelTank(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
            return true;
        }
        return false;
    }

    public void turnOnPowerButton() {
        poweredOn = true;
    }

    public void startAutomaticDriving() {
        // some instructions here, no matter
    }

    private boolean canEntirelyFillUpTheFuelTank(int fuelQuantity) {
        return this.fuelQuantity + fuelQuantity < fuelTankCapacity;
    }

    public Battery getBattery() {
        return battery;
    }
}

class Battery {

    public void charge() {

    }

}