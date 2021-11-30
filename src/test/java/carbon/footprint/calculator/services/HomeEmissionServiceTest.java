package carbon.footprint.calculator.services;

import carbon.footprint.calculator.enums.OptionsElectricityEnum;
import carbon.footprint.calculator.enums.OptionsFuelOilEnum;
import carbon.footprint.calculator.enums.OptionsNaturalGasEnum;
import carbon.footprint.calculator.enums.OptionsPropaneEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class HomeEmissionServiceTest {

    HomeEmissionService homeEmissionService = new HomeEmissionService();

    @Test
    void calculateNaturalGas() {
        BigDecimal input = new BigDecimal(10.0);
        String emissions;

        emissions = homeEmissionService.calculateNaturalGas(input, OptionsNaturalGasEnum.DOLLARS);
        assertEquals("1.343", emissions);

        emissions = homeEmissionService.calculateNaturalGas(input, OptionsNaturalGasEnum.THOUSAND_CUBIC_FEET);
        assertEquals("14.350", emissions);

        emissions = homeEmissionService.calculateNaturalGas(input, OptionsNaturalGasEnum.THERMS);
        assertEquals("1.403", emissions);

    }

    @Test
    void calculateElectricity() {
        BigDecimal input = new BigDecimal(10.0);
        String emissions;

        emissions = homeEmissionService.calculateElectricity(input, OptionsElectricityEnum.DOLLARS);
        assertEquals("6.182", emissions);

        emissions = homeEmissionService.calculateElectricity(input, OptionsElectricityEnum.KWH);
        assertEquals("73.594", emissions);
    }

    @Test
    void calculateFuelOil() {
        BigDecimal input = new BigDecimal(10.0);
        String emissions;

        emissions = homeEmissionService.calculateFuelOil(input, OptionsFuelOilEnum.DOLLARS);
        assertEquals("675.048", emissions);

        emissions = homeEmissionService.calculateFuelOil(input, OptionsFuelOilEnum.GALLONS);
        assertEquals("2.713", emissions);
    }

    @Test
    void calculatePropane() {
        BigDecimal input = new BigDecimal(10.0);
        String emissions;

        emissions = homeEmissionService.calculatePropane(input, OptionsPropaneEnum.DOLLARS);
        assertEquals("603.948", emissions);

        emissions = homeEmissionService.calculatePropane(input, OptionsPropaneEnum.GALLONS);
        assertEquals("1.492", emissions);
    }
}