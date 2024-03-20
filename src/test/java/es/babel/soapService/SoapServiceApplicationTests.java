package es.babel.soapService;

import es.babel.soapService.client.NumbersClient;
import es.babel.soapService.ws.numbers.NumberToDollarsResponse;
import es.babel.soapService.ws.numbers.NumberToWordsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SoapServiceApplicationTests {
	@Autowired
	private NumbersClient numberToWordsClient;
	@Autowired
	private NumbersClient numberToDollarsClient;
	@Autowired
	private Jaxb2Marshaller marshaller;

	@Test
	public void testConvertNumberToDollars() {
		// Given
		BigDecimal number = BigDecimal.valueOf(100);

		// When
		NumberToDollarsResponse response = numberToDollarsClient.convertNumberToDollars(number);

		// Then
		assertThat(response).isNotNull();
		assertThat(response.getNumberToDollarsResult()).isEqualTo("one hundred dollars");
	}

	@Test
	public void testConvertNumberToWords() {
		// Given
		BigInteger number = BigInteger.valueOf(100);

		// When
		NumberToWordsResponse response = numberToWordsClient.convertNumberToWords(number);

		// Then
		assertThat(response).isNotNull();
		assertThat(response.getNumberToWordsResult()).isEqualTo("one hundred ");
	}

}
