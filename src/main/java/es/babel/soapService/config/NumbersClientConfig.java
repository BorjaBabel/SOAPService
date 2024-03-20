package es.babel.soapService.config;

import es.babel.soapService.client.NumbersClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumbersClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("es.babel.soapService.ws.numbers");
        return marshaller;
    }

    @Bean
    public NumbersClient userClient(Jaxb2Marshaller marshaller) {
        NumbersClient client = new NumbersClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
