package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public interface VetService {

	Vet findById(Long id);

	Vet save(Vet owner);

	Set<Vet> findAll();
}
