package pl.lukesawicki.calculator.application.supplier;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RandomOrgClientTest {
    @Test
    void shouldReturnValue() throws IOException {
        RandomOrgClient.newInstance().getNumber();
    }
}