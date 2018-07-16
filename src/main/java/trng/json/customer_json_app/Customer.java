package trng.json.customer_json_app;

import java.time.LocalDate;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties("dateOfBirth")
public class Customer {
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	private double annualSalary;
	private List<Address> addresses;
	private List<PaymentMethod> paymentMethods;

}