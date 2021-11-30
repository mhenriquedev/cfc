package carbon.footprint.calculator.controllers;

import carbon.footprint.calculator.enums.OptionsElectricityEnum;
import carbon.footprint.calculator.enums.OptionsFuelOilEnum;
import carbon.footprint.calculator.enums.OptionsNaturalGasEnum;
import carbon.footprint.calculator.enums.OptionsPropaneEnum;
import carbon.footprint.calculator.services.HomeEmissionService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("home-emission")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(tags = "Home Emission API")
public class HomeEmissionController {

    private final HomeEmissionService service;

    @ApiOperation(value = "calculates the estimated pounds of CO2/year emitted based on natural gas consumption")
    @GetMapping(value = "/natural-gas")
    public ResponseEntity<?> naturalGas(@Validated @NotNull BigDecimal amount, @Validated @NotNull OptionsNaturalGasEnum type) {
        return ResponseEntity.ok(service.calculateNaturalGas(amount, type));
    }

    @ApiOperation(value = "calculates the estimated pounds of CO2/year emitted based on electricity consumption")
    @GetMapping(value = "/electricity")
    public ResponseEntity<?> electricity(@Validated @NotNull BigDecimal amount, @Validated @NotNull OptionsElectricityEnum type) {
        return ResponseEntity.ok(service.calculateElectricity(amount, type));
    }

    @ApiOperation(value = "calculates the estimated pounds of CO2/year emitted based on fuel oil consumption")
    @GetMapping(value = "/fuel-oil")
    public ResponseEntity<?> fuelOil(@Validated @NotNull BigDecimal amount, @Validated @NotNull OptionsFuelOilEnum type) {
        return ResponseEntity.ok(service.calculateFuelOil(amount, type));
    }

    @ApiOperation(value = "calculates the estimated pounds of CO2/year emitted based on propane consumption")
    @GetMapping(value = "/propane")
    public ResponseEntity<?> propane(@Validated @NotNull BigDecimal amount, @Validated @NotNull OptionsPropaneEnum type) {
        return ResponseEntity.ok(service.calculatePropane(amount, type));
    }
}
