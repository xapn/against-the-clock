import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testasyouthink.GivenWhenThenDsl.PreparationStage.Given;

import static testasyouthink.TestAsYouThink.givenSutClass;

class AgainstTheClockTest {

    private Given<AgainstTheClock> givenAgainstTheClockAsSut;

    @BeforeEach
    void prepareFixtures() {
        givenAgainstTheClockAsSut = givenSutClass(AgainstTheClock.class);
    }

    @Test
    void should_start_the_automatic_driving_of_an_autonomous_car() {
        givenAgainstTheClockAsSut
                .givenArgument(() -> new AutonomousCar(new Battery()))
                .whenSutRuns((sut, car) -> sut.start(car, 100))
                .thenItSucceeds();
    }

    @Test
    void should_fail_to_prepare_the_autonomous_car_given_a_lack_of_fuel() {
        givenAgainstTheClockAsSut
                .givenArgument(() -> new AutonomousCar(new Battery()))
                .whenSutRunsOutsideOperatingConditions((sut, car) -> sut.start(car, 99))
                .thenItFails()
                .becauseOf(IllegalStateException.class)
                .withMessage("Can't start an autonomous car without having filled up the fuel tank capacity");
    }
}