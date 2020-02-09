package pl.lukesawicki.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// proszę o wykonanie prostej funkcji, której zadaniem jest dodanie 2 liczb. Jedna z nich niech będzie pobierana z
// hipotetycznego API dostępnego online (można wykorzystać np. https://www.random.org/clients/http/api/), źródło drugiej
// może być dowolne (Math.random(), pobierana z hipotetycznej bazy danych itp). W zadaniu chodzi głównie o pokazanie
// stylu i sposobu kodowania (dekompozycja kodu, podział funkcji itp). Można użyć mockowych źródeł danych, nie muszą
// być zaimplementowane wszystkie przypadki brzegowe (ale warto je mieć z tyłu głowy). Kod ten będzie służył jako punkt
// wyjścia podczas rozmowy rekrutacyjnej. Ważne też, żeby kod napisany był w sposób, jaki uważa Pan za najlepszy pod
// względem designu i stylu.

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
}
