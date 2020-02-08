package pl.lukesawicki.calculator.application.supplier;

import pl.lukesawicki.calculator.domain.NumberSupplier;

class MathRandomSupplier implements NumberSupplier {

    @Override
    public Number get() {
        return Math.random();
    }
}
