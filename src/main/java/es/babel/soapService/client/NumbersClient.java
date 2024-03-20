package es.babel.soapService.client;

import es.babel.soapService.ws.numbers.NumberToDollars;
import es.babel.soapService.ws.numbers.NumberToDollarsResponse;
import es.babel.soapService.ws.numbers.NumberToWords;
import es.babel.soapService.ws.numbers.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumbersClient extends WebServiceGatewaySupport {
    public NumberToDollarsResponse convertNumberToDollars(BigDecimal number) {
        NumberToDollars request = new NumberToDollars();
        request.setDNum(number);

        return (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public NumberToWordsResponse convertNumberToWords(BigInteger number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(number);

        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
