package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import guru.springframework.sfgpetclinic.model.Owner;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class OwnerServiceMapTest {

//	@Mock
//	PetService petService;
//
//	@Mock
//	PetTypeService petTypeService;

	OwnerServiceMap ownerServiceMap;
	private final Long ownerId = 1L;
	private final String lastName = "Smith";


	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
//		ownerServiceMap = new OwnerServiceMap(petTypeService, petService);
		ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void findAll() {
		Set<Owner> owners = ownerServiceMap.findAll();

		assertEquals(1, owners.size());
	}

	@Test
	void findById() {
		Owner owner = ownerServiceMap.findById(ownerId);

		assertEquals(ownerId, owner.getId());
	}

	@Test
	void saveExistingId() {
		Long id = 2L;

		Owner owner2 = Owner.builder().id(id).build();
		Owner savedOwner2 = ownerServiceMap.save(owner2);

		assertEquals(id, savedOwner2.getId());
	}

	@Test
	void saveNoId() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void delete() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void deleteById() {
		ownerServiceMap.deleteById(ownerId);

		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void findByLastName() {
		Owner smith = ownerServiceMap.findByLastName(lastName);

		assertNotNull(smith);
		assertEquals(ownerId, smith.getId());
	}

	@Test
	void findByLastNameNotFound() {
		Owner smith = ownerServiceMap.findByLastName("foo");

		assertNull(smith);
	}
}