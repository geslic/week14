package pet.store.controller.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	
	private Set<PetStoreCustomer> customers;
	private Set<PetStoreEmployee> employees;
	
	// Constructor that takes PetStore as a parameter
	public PetStoreData(PetStore petStore) {
			
		 // Getters and setters
		this.petStoreId = petStore.getPetStoreId();
		this.petStoreName = petStore.getPetStoreName();
		this.petStoreAddress = petStore.getPetStoreAddress();
		this.petStoreCity = petStore.getPetStoreCity();
		this.petStoreState = petStore.getPetStoreState();
		this.petStoreZip = petStore.getPetStoreZip();
		this.petStorePhone = petStore.getPetStorePhone();
		
				
		// Set customers using loop	
		for(Customer customer: petStore.getCustomers()) {
			customers.add(new PetStoreCustomer(customer));
			this.petStoreId = petStore.getPetStoreId();
		}
		
		// Set employees using loop
		for(Employee employee: petStore.getEmployees()) {
			employees.add(new PetStoreEmployee(employee));
			
		}
		

	}
}

