package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementAppUC2.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementAppUC2.Inches;

public class QuantityMeasurementAppUC2Test {

    @Test
    public void testFeetEquality_SameValue() {
        assertEquals(new Feet(1.0), new Feet(1.0));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        assertNotEquals(new Feet(1.0), new Feet(2.0));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        assertNotEquals(new Feet(1.0), null);
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        assertNotEquals(new Feet(1.0), new Object());
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet = new Feet(1.0);
        assertEquals(feet, feet);
    }

    @Test
    public void testInchesEquality_SameValue() {
        assertEquals(new Inches(1.0), new Inches(1.0));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertNotEquals(new Inches(1.0), new Inches(2.0));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        assertNotEquals(new Inches(1.0), null);
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        assertNotEquals(new Inches(1.0), new Object());
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inches = new Inches(1.0);
        assertEquals(inches, inches);
    }
}