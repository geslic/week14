package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;

@Data
@NoArgsConstructor
public class PetStoreCustomer {
	private Long customerID;
	private String customerEmail;
	private String customerFirstName;
	private String customerLastName;
	
	// Constructor that takes a Customer object
	public PetStoreCustomer(Customer customer) {
		this.customerID = customer.getCustomerID();
		this.customerEmail = customer.getCustomerEmail();
		this.customerFirstName = customer.getCustomerFirstName();
		this.customerLastName = customer.getCustomerLastName();
		
	}
	
}
