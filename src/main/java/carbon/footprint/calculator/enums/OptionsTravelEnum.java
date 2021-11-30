package carbon.footprint.calculator.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public enum OptionsTravelEnum {

    VEHICLE(new BigDecimal(0.335)),
    BUS(new BigDecimal(0.053)),
    METRO(new BigDecimal(0.099)),
    TAXI(new BigDecimal(0.335)),
    RAIL(new BigDecimal(0.099)),
    FLYING(new BigDecimal(0));


    private final BigDecimal emissionFactor;
}