public class AutonomousCar {

    private static final int FUEL_TANK_CAPACITY = 100;
    private final Battery battery;
    private int fuelQuantity;
    private boolean poweredOn;

    public AutonomousCar(Battery battery) {
        this.battery = battery;
    }

    void prepareBeforeRace(Fuel fuel) {
        if (automaticDrivingIsReadyYet()) {
            System.out.println("Already prepared! Just start automatic driving now.");
        } else {
            achievePreparation(fuel);
        }
    }

    private boolean automaticDrivingIsReadyYet() {
        return poweredOn;
    }

    private void achievePreparation(Fuel fuel) {
        battery.charge();
        fillUpTheFuelTank(fuel);
        if (fuelTankIsFull()) {
            turnOnPowerButton();
        } else {
            throw new IllegalStateException(
                    "Can't start an autonomous car without having filled up the fuel tank capacity");
        }
    }

    private void fillUpTheFuelTank(Fuel fuel) {
        if (canEntirelyFillUpTheFuelTank(fuel.getQuantity())) {
            this.fuelQuantity = fuel.getQuantity();
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
        return fuelQuantity == FUEL_TANK_CAPACITY;
    }
}
