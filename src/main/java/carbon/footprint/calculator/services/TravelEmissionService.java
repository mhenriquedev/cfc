package carbon.footprint.calculator.services;

import carbon.footprint.calculator.enums.OptionsTravelEnum;
import carbon.footprint.calculator.util.constants.ConstansTravelEmission;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class TravelEmissionService {


    public String calculate(BigDecimal amount, OptionsTravelEnum type) {
        BigDecimal result = null;

        switch (type) {
            case FLYING:

                final BigDecimal SHORT_DISTANCE = new BigDecimal(482);
                final BigDecimal MEDIUM_DISTANCE = new BigDecimal(3701);

                if (amount.compareTo(SHORT_DISTANCE) < 0) {
                    result = amount.multiply(ConstansTravelEmission.EMISSION_FACTOR_FLYING_SHORT).setScale(3, RoundingMode.HALF_UP)
                            .multiply(new BigDecimal(1.09)).setScale(3, RoundingMode.HALF_UP);

                } else if (amount.compareTo(MEDIUM_DISTANCE) < 0) {
                    result = amount.multiply(ConstansTravelEmission.EMISSION_FACTOR_FLYING_MEDIUM).setScale(3, RoundingMode.HALF_UP)
                            .multiply(new BigDecimal(1.09)).setScale(3, RoundingMode.HALF_UP);

                } else if (amount.compareTo(MEDIUM_DISTANCE) > 0) {
                    result = amount.multiply(ConstansTravelEmission.EMISSION_FACTOR_FLYING_LONG).setScale(3, RoundingMode.HALF_UP)
                            .multiply(new BigDecimal(1.09)).setScale(3, RoundingMode.HALF_UP);

                }

                break;

            default:
                result = amount.multiply(type.getEmissionFactor()).setScale(3, RoundingMode.HALF_UP);
        }

        if (Objects.isNull(result)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not estimate carbon emission for Travel.");
        }

        return result.divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP).toString();
    }
}
