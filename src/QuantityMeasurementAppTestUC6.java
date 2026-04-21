package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC6 {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        LengthUC6 length1 = new LengthUC6(1.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 length2 = new LengthUC6(2.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 result = QuantityMeasurementAppUC6.demonstrateLengthAddition(length1, length2);
        assertEquals(new LengthUC6(3.0, LengthUC6.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        LengthUC6 length1 = new LengthUC6(1.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 length2 = new LengthUC6(12.0, LengthUC6.LengthUnit.INCHES);
        LengthUC6 result = QuantityMeasurementAppUC6.demonstrateLengthAddition(length1, length2);
        assertEquals(new LengthUC6(2.0, LengthUC6.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        LengthUC6 length1 = new LengthUC6(12.0, LengthUC6.LengthUnit.INCHES);
        LengthUC6 length2 = new LengthUC6(1.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 result = QuantityMeasurementAppUC6.demonstrateLengthAddition(length1, length2);
        assertEquals(new LengthUC6(24.0, LengthUC6.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        LengthUC6 length1 = new LengthUC6(1.0, LengthUC6.LengthUnit.YARDS);
        LengthUC6 length2 = new LengthUC6(3.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 result = QuantityMeasurementAppUC6.demonstrateLengthAddition(length1, length2);
        assertEquals(new LengthUC6(2.0, LengthUC6.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        LengthUC6 length1 = new LengthUC6(2.54, LengthUC6.LengthUnit.CENTIMETERS);
        LengthUC6 length2 = new LengthUC6(1.0, LengthUC6.LengthUnit.INCHES);
        LengthUC6 result = QuantityMeasurementAppUC6.demonstrateLengthAddition(length1, length2);
        assertEquals(new LengthUC6(5.08, LengthUC6.LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_Commutativity() {
        LengthUC6 length1 = new LengthUC6(1.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 length2 = new LengthUC6(12.0, LengthUC6.LengthUnit.INCHES);

        LengthUC6 res1 = length1.add(length2);
        LengthUC6 res2 = length2.add(length1);

        assertTrue(res1.equals(res2));
    }

    @Test
    public void testAddition_WithZero() {
        LengthUC6 length1 = new LengthUC6(5.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 length2 = new LengthUC6(0.0, LengthUC6.LengthUnit.INCHES);
        LengthUC6 result = length1.add(length2);
        assertEquals(new LengthUC6(5.0, LengthUC6.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NegativeValues() {
        LengthUC6 length1 = new LengthUC6(5.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 length2 = new LengthUC6(-2.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 result = length1.add(length2);
        assertEquals(new LengthUC6(3.0, LengthUC6.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NullOperand_Throws() {
        LengthUC6 length1 = new LengthUC6(1.0, LengthUC6.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length1.add(null));
    }
}