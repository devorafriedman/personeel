package be.vdab.personeel.repositories;

import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    Optional<Werknemer> findByChef(Werknemer chef);
}
