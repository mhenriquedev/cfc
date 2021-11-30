package carbon.footprint.calculator.util.constants;

import java.math.BigDecimal;

public final class ConstansTravelEmission {

    public static final BigDecimal EMISSION_FACTOR_VEHICLE = new BigDecimal(0.335);
    public static final BigDecimal EMISSION_FACTOR_BUS = new BigDecimal(0.053);
    public static final BigDecimal EMISSION_FACTOR_METRO = new BigDecimal(0.099);
    public static final BigDecimal EMISSION_FACTOR_TAXI = new BigDecimal(0.335);
    public static final BigDecimal EMISSION_FACTOR_RAIL = new BigDecimal(0.099);
    public static final BigDecimal EMISSION_FACTOR_FLYING_SHORT = new BigDecimal(0.215);
    public static final BigDecimal EMISSION_FACTOR_FLYING_MEDIUM = new BigDecimal(0.133);
    public static final BigDecimal EMISSION_FACTOR_FLYING_LONG = new BigDecimal(0.165);

    private ConstansTravelEmission() {
        throw new IllegalStateException("Utility class");
    }
}
