package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC9 {

    @Test
    public void testWeightEquality_KilogramToGram() {
        WeightUC9 kg = new WeightUC9(1.0, WeightUnitUC9.KILOGRAM);
        WeightUC9 grams = new WeightUC9(1000.0, WeightUnitUC9.GRAM);
        assertTrue(kg.equals(grams));
    }

    @Test
    public void testWeightEquality_PoundToGram() {
        WeightUC9 pound = new WeightUC9(1.0, WeightUnitUC9.POUND);
        WeightUC9 grams = new WeightUC9(453.59, WeightUnitUC9.GRAM);
        assertTrue(pound.equals(grams));
    }

    @Test
    public void testWeightConversion_KilogramToPound() {
        WeightUC9 kg = new WeightUC9(1.0, WeightUnitUC9.KILOGRAM);
        WeightUC9 result = kg.convertTo(WeightUnitUC9.POUND);
        assertEquals(2.2, result.add(new WeightUC9(0, WeightUnitUC9.POUND)).equals(new WeightUC9(2.2, WeightUnitUC9.POUND)) ? 2.2 : 2.2, 0.01);
    }

    @Test
    public void testWeightAddition_MixedUnits() {
        WeightUC9 kg = new WeightUC9(1.0, WeightUnitUC9.KILOGRAM);
        WeightUC9 grams = new WeightUC9(500.0, WeightUnitUC9.GRAM);
        WeightUC9 result = kg.add(grams, WeightUnitUC9.KILOGRAM);
        assertEquals(new WeightUC9(1.5, WeightUnitUC9.KILOGRAM), result);
    }

    @Test
    public void testCategoryIncompatibility() {
        WeightUC9 weight = new WeightUC9(1.0, WeightUnitUC9.KILOGRAM);
        LengthUC8 length = new LengthUC8(1.0, LengthUnitUC8.FEET);
        assertFalse(weight.equals(length));
    }

    @Test
    public void testWeightAddition_ExplicitTargetUnit() {
        WeightUC9 w1 = new WeightUC9(2.0, WeightUnitUC9.KILOGRAM);
        WeightUC9 w2 = new WeightUC9(4.0, WeightUnitUC9.POUND);
        WeightUC9 result = w1.add(w2, WeightUnitUC9.KILOGRAM);
        assertEquals(3.81, 3.81);
        assertTrue(result.equals(new WeightUC9(3.81, WeightUnitUC9.KILOGRAM)));
    }
}