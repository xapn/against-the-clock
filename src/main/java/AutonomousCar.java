class AutonomousCar {

    private static final int FUEL_TANK_CAPACITY = 100;
    private final Battery battery;
    private int fuelQuantity;
    private boolean poweredOn;

    AutonomousCar(Battery battery) {
        this.battery = battery;
    }

    void prepareBeforeRace() {
        battery.charge();
        fillUpTheFuelTank(100);
        if (!fuelTankIsFull(100)) {
            throw new IllegalStateException(
                    "Can't start an autonomous car without having filled up the fuel tank capacity");
        }
        turnOnPowerButton();
    }

    private void fillUpTheFuelTank(int fuelQuantity) {
        if (canEntirelyFillUpTheFuelTank(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
        }
    }

    private boolean fuelTankIsFull(int fuelQuantity) {
        return canEntirelyFillUpTheFuelTank(fuelQuantity);
    }

    private void turnOnPowerButton() {
        poweredOn = true;
    }

    void startAutomaticDriving() {
        // some instructions here, no matter
    }

    private boolean canEntirelyFillUpTheFuelTank(int fuelQuantity) {
        return this.fuelQuantity + fuelQuantity < FUEL_TANK_CAPACITY;
    }
}
