class AutonomousCar {

    private static final int FUEL_TANK_CAPACITY = 100;
    private final Battery battery;
    private int fuelQuantity;
    private boolean poweredOn;

    AutonomousCar(Battery battery) {
        this.battery = battery;
    }

    void prepareBeforeRace(int fuelQuantity) {
        battery.charge();
        fillUpTheFuelTank(fuelQuantity);
        if (fuelTankIsFull()) {
            turnOnPowerButton();
        } else {
            throw new IllegalStateException(
                    "Can't start an autonomous car without having filled up the fuel tank capacity");
        }
    }

    private void fillUpTheFuelTank(int fuelQuantity) {
        if (canEntirelyFillUpTheFuelTank(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
        }
    }

    private boolean fuelTankIsFull() {
        return fuelQuantity == FUEL_TANK_CAPACITY;
    }

    private void turnOnPowerButton() {
        poweredOn = true;
    }

    void startAutomaticDriving() {
        System.out.println("Some instructions here, no matter.");
    }

    private boolean canEntirelyFillUpTheFuelTank(int fuelQuantity) {
        return this.fuelQuantity + fuelQuantity == FUEL_TANK_CAPACITY;
    }
}
