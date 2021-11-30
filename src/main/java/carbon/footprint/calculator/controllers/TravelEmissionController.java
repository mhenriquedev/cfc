package carbon.footprint.calculator.controllers;

import carbon.footprint.calculator.enums.*;
import carbon.footprint.calculator.services.TravelEmissionService;
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
@RequestMapping("travel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Api(tags = "Travel Emission API")
public class TravelEmissionController {

    private final TravelEmissionService service;

    @ApiOperation(value = "calculates the emission of CO2e/yr based on distance and model of transport")
    @GetMapping
    public ResponseEntity<?> calculate(@Validated @NotNull BigDecimal amount, @Validated @NotNull OptionsTravelEnum type) {
        return ResponseEntity.ok(service.calculate(amount, type));
    }
}
