package be.vdab.personeel.repositories;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface JobtitelRepository extends JpaRepository<Jobtitel, Long> {

}
