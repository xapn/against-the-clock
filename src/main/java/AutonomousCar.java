class AutonomousCar {

    private static final int fuelTankCapacity = 100;
    private final Battery battery;
    private int fuelQuantity;
    private boolean poweredOn;

    AutonomousCar(Battery battery) {
        this.battery = battery;
    }

    void prepareBeforeRace() {
        battery.charge();
        if (!fillUpTheFuelTank(100)) {
            throw new IllegalStateException(
                    "Can't start an autonomous car without having filled up the fuel tank capacity");
        }
        turnOnPowerButton();
    }

    private boolean fillUpTheFuelTank(int fuelQuantity) {
        if (canEntirelyFillUpTheFuelTank(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
            return true;
        }
        return false;
    }

    private void turnOnPowerButton() {
        poweredOn = true;
    }

    void startAutomaticDriving() {
        // some instructions here, no matter
    }

    private boolean canEntirelyFillUpTheFuelTank(int fuelQuantity) {
        return this.fuelQuantity + fuelQuantity < fuelTankCapacity;
    }
}
