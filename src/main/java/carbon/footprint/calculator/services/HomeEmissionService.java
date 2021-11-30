package carbon.footprint.calculator.services;

import carbon.footprint.calculator.enums.OptionsElectricityEnum;
import carbon.footprint.calculator.enums.OptionsFuelOilEnum;
import carbon.footprint.calculator.enums.OptionsNaturalGasEnum;
import carbon.footprint.calculator.enums.OptionsPropaneEnum;
import carbon.footprint.calculator.util.constants.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class HomeEmissionService {


    public String calculateNaturalGas(BigDecimal averageAmount, OptionsNaturalGasEnum type) {
        BigDecimal result = null;


        switch (type) {
            case DOLLARS:
                result = averageAmount.divide(ConstansHomeEmissionNaturalGas.PRICE_THOUSAND_CUBIC_FEET, 3, RoundingMode.HALF_UP)
                        .multiply(ConstansHomeEmissionNaturalGas.EMISSION_FACTOR_NATURAL_GAS).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP)
                        .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
                break;

            case THOUSAND_CUBIC_FEET:
                result = (averageAmount.multiply(ConstansHomeEmissionNaturalGas.EMISSION_FACTOR_NATURAL_GAS).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP))
                        .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
                break;

            case THERMS:
                result = (averageAmount.multiply(ConstansHomeEmissionNaturalGas.EMISSION_FACTOR_NATURAL_GAS_THERM).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP))
                        .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
                break;
        }
        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not estimate carbon emission for Natural Gas.");
        }

        return result.toString();
    }

    public String calculateElectricity(BigDecimal averageAmount, OptionsElectricityEnum type) {
        BigDecimal result = null;


        switch (type) {
            case DOLLARS:
                result = (averageAmount.divide(ConstansHomeEmissionElectricity.PRICE_PER_KWH, 3, RoundingMode.HALF_UP))
                        .multiply(ConstansHomeEmissionElectricity.EMISSION_FACTOR_ELECTRICITY).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP);
                break;

            case KWH:
                result = (averageAmount.multiply(ConstansHomeEmissionElectricity.EMISSION_FACTOR_ELECTRICITY).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP));
                break;
        }
        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not estimate carbon emission for Electricity.");
        }

        return result.divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP).toString();
    }

    public String calculateFuelOil(BigDecimal averageAmount, OptionsFuelOilEnum type) {
        BigDecimal result = null;


        switch (type) {
            case DOLLARS:
                result = (averageAmount.divide(ConstansHomeEmissionFuelOil.PRICE_PER_GALLON, 3, RoundingMode.HALF_UP))
                        .multiply(ConstansHomeEmissionFuelOil.EMISSION_FACTOR_FUEL_OIL).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP);
                break;

            case GALLONS:
                result = (averageAmount.multiply(ConstansHomeEmissionFuelOil.EMISSION_FACTOR_FUEL_OIL).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP))
                        .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
                break;
        }
        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not estimate carbon emission for Fuel Oil.");
        }

        return result.toString();
    }

    public String calculatePropane(BigDecimal averageAmount, OptionsPropaneEnum type) {
        BigDecimal result = null;


        switch (type) {
            case DOLLARS:
                result = (averageAmount.divide(ConstansHomeEmissionPropane.PRICE_PER_GALLON, 3, RoundingMode.HALF_UP))
                        .multiply(ConstansHomeEmissionPropane.EMISSION_FACTOR_PROPANE).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP);
                break;

            case GALLONS:
                result = (averageAmount.multiply(ConstansHomeEmissionPropane.EMISSION_FACTOR_PROPANE).setScale(3, RoundingMode.HALF_UP)
                        .multiply(ConstansCarbonFootprintCalculator.MONTHS_YEAR).setScale(3, RoundingMode.HALF_UP))
                        .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
                break;
        }
        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not estimate carbon emission for Propane.");
        }

        return result.toString();
    }
}
