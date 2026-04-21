package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC5 {

    @Test
    public void testConversion_FeetToInches() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(1.0, LengthUC5.LengthUnit.FEET, LengthUC5.LengthUnit.INCHES);
        assertEquals(new LengthUC5(12.0, LengthUC5.LengthUnit.INCHES), result);
    }

    @Test
    public void testConversion_InchesToFeet() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(24.0, LengthUC5.LengthUnit.INCHES, LengthUC5.LengthUnit.FEET);
        assertEquals(new LengthUC5(2.0, LengthUC5.LengthUnit.FEET), result);
    }

    @Test
    public void testConversion_YardsToInches() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(1.0, LengthUC5.LengthUnit.YARDS, LengthUC5.LengthUnit.INCHES);
        assertEquals(new LengthUC5(36.0, LengthUC5.LengthUnit.INCHES), result);
    }

    @Test
    public void testConversion_InchesToYards() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(72.0, LengthUC5.LengthUnit.INCHES, LengthUC5.LengthUnit.YARDS);
        assertEquals(new LengthUC5(2.0, LengthUC5.LengthUnit.YARDS), result);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(1.0, LengthUC5.LengthUnit.CENTIMETERS, LengthUC5.LengthUnit.INCHES);
        assertTrue(result.equals(new LengthUC5(0.39, LengthUC5.LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_FeetToYard() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(6.0, LengthUC5.LengthUnit.FEET, LengthUC5.LengthUnit.YARDS);
        assertEquals(new LengthUC5(2.0, LengthUC5.LengthUnit.YARDS), result);
    }

    @Test
    public void testConversion_ZeroValue() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(0.0, LengthUC5.LengthUnit.FEET, LengthUC5.LengthUnit.INCHES);
        assertEquals(new LengthUC5(0.0, LengthUC5.LengthUnit.INCHES), result);
    }

    @Test
    public void testConversion_NegativeValue() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(-1.0, LengthUC5.LengthUnit.FEET, LengthUC5.LengthUnit.INCHES);
        assertEquals(new LengthUC5(-12.0, LengthUC5.LengthUnit.INCHES), result);
    }

    @Test
    public void testConversion_SameUnit() {
        LengthUC5 result = QuantityMeasurementAppUC5.demonstrateLengthConversion(5.0, LengthUC5.LengthUnit.FEET, LengthUC5.LengthUnit.FEET);
        assertEquals(new LengthUC5(5.0, LengthUC5.LengthUnit.FEET), result);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementAppUC5.demonstrateLengthConversion(1.0, LengthUC5.LengthUnit.FEET, null);
        });
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        LengthUC5 start = new LengthUC5(1.0, LengthUC5.LengthUnit.FEET);
        LengthUC5 toInches = start.convertTo(LengthUC5.LengthUnit.INCHES);
        LengthUC5 backToFeet = toInches.convertTo(LengthUC5.LengthUnit.FEET);
        assertEquals(start, backToFeet);
    }

    @Test
    public void testConversion_YardsToInchesUsingOverloadedMethod() {
        LengthUC5 lengthInYards = new LengthUC5(2.0, LengthUC5.LengthUnit.YARDS);
        LengthUC5 lengthInInches = QuantityMeasurementAppUC5.demonstrateLengthConversion(lengthInYards, LengthUC5.LengthUnit.INCHES);
        LengthUC5 expectedLength = new LengthUC5(72.0, LengthUC5.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementAppUC5.demonstrateLengthEquality(lengthInInches, expectedLength));
    }
}