package pl.lukesawicki.calculator.application.supplier;

import com.google.common.io.CharStreams;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
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
        try {
            return getRandomNumber();
        } catch (IOException e) {
            log.error("Boom", e);
            throw new IllegalStateException(e);
        }
    }

    private Number getRandomNumber() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if(200 != connection.getResponseCode()) {
            throw new IllegalStateException("Response from random.org is not ok.");
        }
        Integer value = parseHttpResponse(connection);
        connection.disconnect();
        return value;
    }

    private int parseHttpResponse(HttpURLConnection connection) throws IOException {
        try (final Reader reader = new InputStreamReader((InputStream) connection.getContent())) {
            return Integer.valueOf(CharStreams.toString(reader).replaceAll("\\s",""));
        }
    }

}
