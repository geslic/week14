package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	
	@Autowired
	private PetStoreDao petStoreDao;
	
	
	
// methods
	
	/*private PetStoreData createPetStoreData(PetStoreData petStoreData) {
		// TODO Auto-generated method stub
		PetStore petStore = new PetStore();
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		petStore.setPetStoreState(petStoreData.getPetStoreState());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
		
		
		return petStoreData;
	}*/

	@Transactional(readOnly = false)
	private PetStore findPetStoreById(Long petStoreId) {
		// TODO Auto-generated method stub
		Optional<PetStore> optionalPetStore = petStoreDao.findById(petStoreId);
		
		return optionalPetStore.orElse(null);
	}
	@Transactional(readOnly = false)
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		// TODO Auto-generated method stub
		// Call findOrCreatePetStore(petStoreId)
		PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());
		
		// If not null, findPetStoreById
		if (petStore.getPetStoreId() != null) {
			PetStore existingPetStore = findPetStoreById(petStore.getPetStoreId());
			
			// If no matching pet store is found, throw a NoSuchElementException
			if (existingPetStore == null) {
				throw new NoSuchElementException("Pet store with ID " + petStore.getPetStoreId() + " not found");
			}
		}
		// Call copyPetStoreFields()
		copyPetStoreFields(petStore, petStoreData);
		
		// Call the PetStoreDao method save(petStore)
		PetStore savedPetStore = petStoreDao.save(petStore);
		
		// Return a new PetStoreData object created from the return value of the save() method
		return new PetStoreData(savedPetStore);
		
	}
	@Transactional(readOnly = false)
	public PetStore findOrCreatePetStore(Long petStoreId) {
		// TODO Auto-generated method stub
		if (petStoreId == null) {
			// Create a new PetStore if the ID is null
			return new PetStore();
		}else {
			// Try to find an existing PetStore by ID
			return petStoreDao.findById(petStoreId).orElseGet(() -> {
				// If not found, create a new PetStore
				return new PetStore();
			});
		}
		
	}
	@Transactional(readOnly = false)
	private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		// Copy matching fields from PetStoreData to PetStore
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		petStore.setPetStoreState(petStoreData.getPetStoreState());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
	}
	
	
}
