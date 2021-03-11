package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class DefaultWerknemerService implements WerknemerService{
    private final WerknemerRepository repository;

    public DefaultWerknemerService(WerknemerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Werknemer> findByChef(Werknemer chef) {
        return repository.findByChef(chef);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Werknemer> findById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void opslagGeven(long id, BigDecimal bedrag) {
        var aanwezigWerknemer=repository.findById(id);
        if (aanwezigWerknemer.isPresent()){
            var werknemer = aanwezigWerknemer.get();
            werknemer.opslagGeven(bedrag);
            repository.save(werknemer);
        }

    }
}
