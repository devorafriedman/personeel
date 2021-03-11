package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;

import java.math.BigDecimal;
import java.util.Optional;

public interface WerknemerService {
    public Optional<Werknemer> findByChef(Werknemer chef);
    public Optional<Werknemer> findById(long id);
    public void opslagGeven(long id, BigDecimal bedrag);
}
