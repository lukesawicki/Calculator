package pl.lukesawicki.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DefaultCalculatorTest {

    private final DefaultCalculator defaultCalculator = new DefaultCalculator();

    @Test
    void throwExceptionForNullArguments() {

        //Expect
        assertThatThrownBy( () ->
                defaultCalculator.add(getNumberSupplier(null), getNumberSupplier(3.0f)))
                .isExactlyInstanceOf(NullPointerException.class)
                .hasMessageContaining("Number is null");

    }

    @Test
    void shouldAddValidArguments() {
        //Given
        NumberSupplier one = getNumberSupplier(2);
        NumberSupplier two = getNumberSupplier(3);
        //When

        Number result = defaultCalculator.add(one, two);

        //Then
        assertThat(result).isEqualTo(5.0);
    }

    private static NumberSupplier getNumberSupplier(Number number) {
        return () -> number;
    }


}