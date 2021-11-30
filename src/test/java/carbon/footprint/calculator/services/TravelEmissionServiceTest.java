package carbon.footprint.calculator.services;

import carbon.footprint.calculator.enums.OptionsTravelEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TravelEmissionServiceTest {

    TravelEmissionService travelEmissionService = new TravelEmissionService();

    @Test
    void calculate() {
        BigDecimal input = new BigDecimal(10.0);
        String emissions;

        emissions = travelEmissionService.calculate(input, OptionsTravelEnum.VEHICLE);
        assertEquals("0.003", emissions);

        emissions = travelEmissionService.calculate(input, OptionsTravelEnum.BUS);
        assertEquals("0.001", emissions);

        emissions = travelEmissionService.calculate(input, OptionsTravelEnum.METRO);
        assertEquals("0.001", emissions);

        emissions = travelEmissionService.calculate(input, OptionsTravelEnum.TAXI);
        assertEquals("0.003", emissions);

        emissions = travelEmissionService.calculate(input, OptionsTravelEnum.RAIL);
        assertEquals("0.001", emissions);

    }
}