package pl.lukesawicki.calculator.application.supplier;

import com.google.common.io.CharStreams;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.Opt;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Optional;


@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class RandomOrgClient {
    private final URL url;

    static RandomOrgClient newInstance() {
        try {
            return new RandomOrgClient(new URL("https://www.random.org/integers/?num=1&min=1&max=999&col=1&base=10&format=plain&rnd=new"));
        } catch (MalformedURLException e) {
            log.error("Malformed url", e);
            throw new IllegalStateException(e);
        }
    }

    Number getNumber(){
        return getRandomNumber();
    }

    private Number getRandomNumber() {
        Number number = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
             number = parseHttpResponse(connection);
            connection.disconnect();
        } catch (ProtocolException exception) {
            log.error("Error during parsing HTTP response", exception);
        } catch (IOException exception) {
            log.error("Error during parsing HTTP response", exception);
        } catch (Exception exception) {
            log.error("Error", exception);
        }
        return number;
    }

    private double parseHttpResponse(HttpURLConnection connection) throws IOException {
        try (final Reader reader = new InputStreamReader((InputStream) connection.getContent())) {
            return Double.parseDouble(CharStreams.toString(reader).replaceAll("\\s",""));
        }
    }
}
