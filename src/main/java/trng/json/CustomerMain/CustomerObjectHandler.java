package trng.json.CustomerMain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import trng.json.customer_json_app.Address;
import trng.json.customer_json_app.Customer;
import trng.json.customer_json_app.PaymentMethod;

public class CustomerObjectHandler {

	public void serialize() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper oM = new ObjectMapper();
		String filename = "C:\\Users\\User\\eclipse-workspace\\customer-json-app\\src\\main\\resources\\customer1.json";
		File file = new File(filename);
		Customer c = createCustomer();
		oM.configure(SerializationFeature.INDENT_OUTPUT, true);

		oM.writeValue(file, c);

	}

	public static Customer createCustomer() {
		Customer c = new Customer();
		c.setId(102);
		c.setName("Khulla");
		c.setDateOfBirth(LocalDate.of(1992, 9, 23));
		c.setAnnualSalary(34000.67);
		List<Address> addresses = new ArrayList<>();
		Address a = new Address();
		a.setStreet("1235 MullHound Blvd");
		a.setCity("San Pedro, WA");
		a.setZipCode("345-095");
		addresses.add(a);
		c.setAddresses(addresses);
		PaymentMethod pm = new PaymentMethod();
		pm.setCardNumber(50915607);
		pm.setCardName("Suntrust");
		pm.setDateFrom(LocalDate.of(2012, 02, 19));
		pm.setDateType("in range");
		pm.setCardType("DEBITCARD");
		List<PaymentMethod> paymentMethods = new ArrayList<>();
		paymentMethods.add(pm);
		c.setPaymentMethods(paymentMethods);
		return c;
	}
	
	public void deserialize() throws IOException {
		String path="C:\\Users\\User\\eclipse-workspace\\customer-json-app\\src\\main\\resources\\customer.json";
		byte[] jsonData = Files.readAllBytes(Paths.get(path));
    	ObjectMapper objectMapper = new ObjectMapper();
    	
        //Read JSON data into HashMap
        Map<String, Object> myMap = new HashMap<>();
        myMap = objectMapper.readValue(jsonData, HashMap.class);
        System.out.println("Map is: "+ myMap);
	}
	
	public static void main(String args[]) {
		CustomerObjectHandler coh=new CustomerObjectHandler();
		try {
			coh.serialize();
			coh.deserialize();
		} catch (JsonGenerationException e) {
			System.out.println("Json generation failed\n");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("JSON mapping failed\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem writing to the file specified\n");
			e.printStackTrace();
		}

	}

}