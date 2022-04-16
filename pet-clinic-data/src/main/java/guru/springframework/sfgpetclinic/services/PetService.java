package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public interface PetService {

	Pet findById(Long id);

	Pet save(Pet owner);

	Set<Pet> findAll();
}
