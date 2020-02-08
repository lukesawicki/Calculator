package pl.lukesawicki.calculator.application.supplier;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import pl.lukesawicki.calculator.domain.NumberSupplier;

@AllArgsConstructor
public class RandomOrgNumberSupplier implements NumberSupplier {
    private final RandomOrgClient randomOrgClient;

    @Override
    public Number get() {
        return randomOrgClient.getNumber();
    }
}
