package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC8 {

    @Test
    public void testLengthUnitEnum_ConversionToInches() {
        assertEquals(12.0, LengthUnitUC8.FEET.convertToBaseUnit(1.0));
        assertEquals(36.0, LengthUnitUC8.YARDS.convertToBaseUnit(1.0));
    }

    @Test
    public void testLengthUnitEnum_ConversionFromInches() {
        assertEquals(1.0, LengthUnitUC8.FEET.convertFromBaseUnit(12.0));
        assertEquals(1.0, LengthUnitUC8.YARDS.convertFromBaseUnit(36.0));
    }

    @Test
    public void testQuantityLengthRefactored_Equality() {
        LengthUC8 l1 = new LengthUC8(1.0, LengthUnitUC8.FEET);
        LengthUC8 l2 = new LengthUC8(12.0, LengthUnitUC8.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {
        LengthUC8 l1 = new LengthUC8(1.0, LengthUnitUC8.FEET);
        LengthUC8 result = l1.convertTo(LengthUnitUC8.INCHES);
        assertEquals(new LengthUC8(12.0, LengthUnitUC8.INCHES), result);
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        LengthUC8 l1 = new LengthUC8(1.0, LengthUnitUC8.FEET);
        LengthUC8 l2 = new LengthUC8(12.0, LengthUnitUC8.INCHES);
        LengthUC8 result = l1.add(l2, LengthUnitUC8.YARDS);
        assertEquals(new LengthUC8(0.67, LengthUnitUC8.YARDS), result);
    }

    @Test
    public void testQuantityLengthRefactored_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new LengthUC8(1.0, null));
    }

    @Test
    public void testBackwardCompatibility_AllPreviousFunctionalities() {
        LengthUC8 yard = new LengthUC8(1.0, LengthUnitUC8.YARDS);
        LengthUC8 inches = new LengthUC8(36.0, LengthUnitUC8.INCHES);
        LengthUC8 cm = new LengthUC8(2.54, LengthUnitUC8.CENTIMETERS);

        assertTrue(yard.equals(inches));
        assertTrue(cm.equals(new LengthUC8(1.0, LengthUnitUC8.INCHES)));
    }
}