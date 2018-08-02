import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static testasyouthink.TestAsYouThink.givenSutClass;

class AgainstTheClockTest {

    @Nested
    @DisplayName("Characterization tests")
    class CharacterizationTesting {

        @Test
        void cover_at_65_percent() {
            givenSutClass(AgainstTheClock.class)
                    .givenArgument(() -> new AutonomousCar(new Battery()))
                    .whenSutRunsOutsideOperatingConditions((sut, car) -> sut.start(car, 100))
                    .thenItFails();
        }
    }
}