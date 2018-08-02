class AutonomousCar {

    private static final int fuelTankCapacity = 100;
    private int fuelQuantity;
    private boolean poweredOn;
    private final Battery battery;

    AutonomousCar(Battery battery) {
        this.battery = battery;
    }

    boolean fillUpTheFuelTank(int fuelQuantity) {
        if (canEntirelyFillUpTheFuelTank(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
            return true;
        }
        return false;
    }

    void turnOnPowerButton() {
        poweredOn = true;
    }

    void startAutomaticDriving() {
        // some instructions here, no matter
    }

    private boolean canEntirelyFillUpTheFuelTank(int fuelQuantity) {
        return this.fuelQuantity + fuelQuantity < fuelTankCapacity;
    }

    Battery getBattery() {
        return battery;
    }
}
