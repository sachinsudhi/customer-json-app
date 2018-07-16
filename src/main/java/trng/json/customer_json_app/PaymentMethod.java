package trng.json.customer_json_app;

import java.time.LocalDate;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class PaymentMethod{
	private long cardNumber;
	private String cardName;
	private LocalDate dateFrom;
	private String dateType;
	private String cardType;
}