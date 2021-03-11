package be.vdab.personeel.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "werknemers")
public class Werknemer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String familienaam;
    private String voornaam;
    private String email;
    @OneToMany
    @JoinColumn(name = "chefid")
    @OrderBy("id")
    private Set<Werknemer> ondergeschikten;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chefid")
    private Werknemer chef;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jobtitelid")
    private Jobtitel jobtitel;
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal salaris;
    @DateTimeFormat(pattern = "d-M-yy")
    private LocalDate geboorte;
    @Version
    private int versie;

    public long getId() {
        return id;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getEmail() {
        return email;
    }

    public Set<Werknemer> getOndergeschikten() {
        return Collections.unmodifiableSet(ondergeschikten);
    }

    public Werknemer getChef() {
        return chef;
    }

    public Jobtitel getJobtitel() {
        return jobtitel;
    }

    public BigDecimal getSalaris() {
        return salaris;
    }

    public LocalDate getGeboorte() {
        return geboorte;
    }

    public int getVersie() {
        return versie;
    }

    public void opslagGeven(BigDecimal opslag) {
        this.salaris = salaris.add(opslag);
    }
}
