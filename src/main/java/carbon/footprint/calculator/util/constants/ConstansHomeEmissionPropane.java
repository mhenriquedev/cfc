package carbon.footprint.calculator.util.constants;

import java.math.BigDecimal;

public final class ConstansHomeEmissionPropane {

    public static final BigDecimal PRICE_PER_GALLON = new BigDecimal(2.47);
    public static final BigDecimal EMISSION_FACTOR_PROPANE = new BigDecimal(12.43);

    private ConstansHomeEmissionPropane() {
        throw new IllegalStateException("Utility class");
    }
}
