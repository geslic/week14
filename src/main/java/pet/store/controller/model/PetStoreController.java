package pet.store.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	@Autowired
	private PetStoreService petStoreService;
	
	@PutMapping("/{petStoreId}")
	public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody
			PetStoreData petStoreData) {
		log.info("Received a PUT request to /pet_store/{} with data: {}", petStoreId, 
		petStoreData);
		
		// Set the pet store ID in the pet store data from  the ID parameter
		petStoreData.setPetStoreId(petStoreId);
		
		// Call the savePetStore method in the service class
		PetStoreData updatedPetStoreData = petStoreService.savePetStore(petStoreData);
		
		return updatedPetStoreData;
	}
	
	//@Autowired
	//public PetStoreController(PetStoreService petStoreService) {
		
			//this.petStoreService = petStoreService;			
		//}
	
	@PostMapping
	
	public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Received a POST request to /pet_store with data: {}", petStoreData);
		
		// Call the service method to save or modify pet store data
		PetStoreData savedPetStoreData = petStoreService.savePetStore(petStoreData);
		
		// Return the saved or modified PetStoreData object
		return savedPetStoreData;
		}
	}


