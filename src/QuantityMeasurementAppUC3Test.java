package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppUC3Test {

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(feet, inches);
    }

    @Test
    public void testFeetInequality() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testInchesInequality() {
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertNotEquals(inches1, inches2);
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(1.0, Length.LengthUnit.INCHES);
        assertNotEquals(feet, inches);
    }

    @Test
    public void testMultipleFeetComparison() {
        Length feet1 = new Length(2.0, Length.LengthUnit.FEET);
        Length inches = new Length(24.0, Length.LengthUnit.INCHES);
        assertEquals(feet1, inches);
    }

    @Test
    public void testEquality_NullComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(null, feet);
    }

    @Test
    public void testEquality_SameReference() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(feet, feet);
    }
}