package be.vdab.personeel.forms;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OpslagForm {
    private final long werknemerid;
    @Positive
    private final BigDecimal opslag;

    public OpslagForm(long werknemerid, BigDecimal opslag) {
        this.werknemerid = werknemerid;
        this.opslag = opslag;
    }

    public long getWerknemerid() {
        return werknemerid;
    }

    public BigDecimal getOpslag() {
        return opslag;
    }
}
