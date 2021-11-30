package carbon.footprint.calculator.util.constants;

import java.math.BigDecimal;

public final class ConstansHomeEmissionElectricity {

    public static final BigDecimal PRICE_PER_KWH = new BigDecimal(11.9);
    public static final BigDecimal EMISSION_FACTOR_ELECTRICITY = new BigDecimal(613.2845f);

    private ConstansHomeEmissionElectricity() {
        throw new IllegalStateException("Utility class");
    }
}
