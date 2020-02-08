package pl.lukesawicki.calculator.domain;

public interface Calculator {
    //Hiding implementation
    static Calculator newInstance(){
        return new DefaultCalculator();
    }

    Number add(NumberSupplier numberSupplierOne, NumberSupplier numberSupplierTwo);
}
