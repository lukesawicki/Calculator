package pl.lukesawicki.calculator.application.supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RandomOrgNumberSupplierTest {

    @Mock
    private RandomOrgClient randomOrgClient;

    @InjectMocks
    private RandomOrgNumberSupplier supplier;

    @Test
    public void happyPath() {
        //Given
        given(randomOrgClient.getNumber()).willReturn(4);

        //When
        Number result = supplier.get();

        //Then
        assertThat(result).isEqualTo(4);
    }
}