package pl.lukesawicki.calculator.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lukesawicki.calculator.domain.Calculator;

@Configuration
public class CalculatorConfiguration {
    @Bean
    Calculator calculator(){
        return Calculator.newInstance();
    }
    @Bean
    CalculatorService calculatorService(Calculator calculator){
        return new CalculatorService(calculator);
    }
}
