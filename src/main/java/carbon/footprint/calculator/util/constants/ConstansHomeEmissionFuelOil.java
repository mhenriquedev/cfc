package carbon.footprint.calculator.util.constants;

import java.math.BigDecimal;

public final class ConstansHomeEmissionFuelOil {

    public static final BigDecimal PRICE_PER_GALLON = new BigDecimal(4.02);
    public static final BigDecimal EMISSION_FACTOR_FUEL_OIL = new BigDecimal(22.61);

    private ConstansHomeEmissionFuelOil() {
        throw new IllegalStateException("Utility class");
    }
}
