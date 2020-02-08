package pl.lukesawicki.calculator.domain;

import com.google.common.base.Preconditions;

class DefaultCalculator implements Calculator {
    @Override
    public Number add(NumberSupplier numberSupplierOne, NumberSupplier numberSupplierTwo) {
        Number numberOne = getNumber(numberSupplierOne);
        Number numberTwo = getNumber(numberSupplierTwo);
        return numberOne.doubleValue() + numberTwo.doubleValue();
    }
    private Number getNumber(NumberSupplier numberSupplier) {
        Number number = numberSupplier.get();
        Preconditions.checkNotNull(number, "Number is null");
        return number;
    }
}
