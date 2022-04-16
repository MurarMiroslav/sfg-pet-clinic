package guru.springframework.sfgpetclinic.services;


import guru.springframework.sfgpetclinic.model.Owner;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {

	Owner findByLastName(String lastName);

	Owner findById(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();
}
