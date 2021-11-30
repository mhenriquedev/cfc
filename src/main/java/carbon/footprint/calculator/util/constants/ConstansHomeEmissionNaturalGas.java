package carbon.footprint.calculator.util.constants;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ConstansHomeEmissionNaturalGas {

    public static final BigDecimal EMISSION_FACTOR_NATURAL_GAS = new BigDecimal(119.58);
    public static final BigDecimal EMISSION_FACTOR_NATURAL_GAS_THERM = new BigDecimal(11.68890913);
    public static final BigDecimal PRICE_THOUSAND_CUBIC_FEET = new BigDecimal(10.68);

    private ConstansHomeEmissionNaturalGas() {
        throw new IllegalStateException("Utility class");
    }
}
