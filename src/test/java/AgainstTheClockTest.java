import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.givenSutClass;

class AgainstTheClockTest {

    @Nested
    @DisplayName("Characterization tests")
    class CharacterizationTesting {

        @Test
        void cover_at_100_percent() {
            givenSutClass(AgainstTheClock.class)
                    .givenArgument(() -> new AutonomousCar(new Battery()))
                    .whenSutRunsOutsideOperatingConditions((sut, car) -> sut.start(car, 99))
                    .thenItFails();
        }
    }

    @Nested
    @DisplayName("Fixes")
    class DefectBasedTesting {

        @Test
        void should_fix_the_fuel_tank_filling() {
            givenSutClass(AgainstTheClock.class)
                    .givenArgument(() -> new AutonomousCar(new Battery()))
                    .whenSutRuns((sut, car) -> sut.start(car, 100))
                    .thenItSucceeds();
        }
    }
}