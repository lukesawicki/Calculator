package pl.lukesawicki.calculator.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.lukesawicki.calculator.domain.Calculator;
import pl.lukesawicki.calculator.domain.NumberSupplier;

@AllArgsConstructor
public class CalculatorService {
    private final Calculator calculator;

    public Number addNumbers(NumberSupplier one, NumberSupplier two) {
        return calculator.add(one, two);
    }
}
