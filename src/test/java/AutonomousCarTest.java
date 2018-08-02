import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static testasyouthink.TestAsYouThink.givenSut;

class AutonomousCarTest {

    @Test
    void should_fix_the_car_preparation_when_there_are_2_preparations() {
        givenSut(() -> new AutonomousCar(new Battery()))
                .when(sut -> {
                    sut.prepareBeforeRace(new Fuel(100));
                    sut.prepareBeforeRace(new Fuel(0));
                })
                .thenStandardOutput(stdout -> assertThat(stdout).hasContent("Charged.\n" //
                        + "Already prepared! Just start automatic driving now."));
    }
}