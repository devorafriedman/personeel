package be.vdab.personeel.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jobtitels")
public class Jobtitel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @OneToMany
    @JoinColumn(name = "jobtitelid")
    private Set<Werknemer> werknemers;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Werknemer> getWerknemers() {
        return Collections.unmodifiableSet(werknemers);
    }
}
