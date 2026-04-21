package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC7 {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(12.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 result = l1.add(l2, LengthUC7.LengthUnit.FEET);
        assertEquals(new LengthUC7(2.0, LengthUC7.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(12.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 result = l1.add(l2, LengthUC7.LengthUnit.INCHES);
        assertEquals(new LengthUC7(24.0, LengthUC7.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(12.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 result = l1.add(l2, LengthUC7.LengthUnit.YARDS);
        assertEquals(new LengthUC7(0.667, LengthUC7.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 l2 = new LengthUC7(1.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 result = l1.add(l2, LengthUC7.LengthUnit.CENTIMETERS);
        assertEquals(new LengthUC7(5.08, LengthUC7.LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(12.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 res1 = l1.add(l2, LengthUC7.LengthUnit.YARDS);
        LengthUC7 res2 = l2.add(l1, LengthUC7.LengthUnit.YARDS);
        assertTrue(res1.equals(res2));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        LengthUC7 l1 = new LengthUC7(5.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(0.0, LengthUC7.LengthUnit.INCHES);
        LengthUC7 result = l1.add(l2, LengthUC7.LengthUnit.YARDS);
        assertEquals(new LengthUC7(1.667, LengthUC7.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(12.0, LengthUC7.LengthUnit.INCHES);
        assertThrows(IllegalArgumentException.class, () -> l1.add(l2, null));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        LengthUC7 l1 = new LengthUC7(1000.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(500.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 result = l1.add(l2, LengthUC7.LengthUnit.INCHES);
        assertEquals(new LengthUC7(18000.0, LengthUC7.LengthUnit.INCHES), result);
    }
}