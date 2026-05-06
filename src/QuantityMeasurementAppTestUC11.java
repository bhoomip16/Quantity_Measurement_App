package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTestUC11 {

    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {
        QuantityUC10<VolumeUnitUC11> litre = new QuantityUC10<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC10<VolumeUnitUC11> ml = new QuantityUC10<>(1000.0, VolumeUnitUC11.MILLILITRE);
        assertTrue(litre.equals(ml)); //
    }

    @Test
    public void testEquality_LitreToGallon_EquivalentValue() {
        QuantityUC10<VolumeUnitUC11> litre = new QuantityUC10<>(3.785, VolumeUnitUC11.LITRE);
        QuantityUC10<VolumeUnitUC11> gallon = new QuantityUC10<>(1.0, VolumeUnitUC11.GALLON);
        assertTrue(litre.equals(gallon)); //
    }

    @Test
    public void testConversion_GallonToLitre() {
        QuantityUC10<VolumeUnitUC11> gallon = new QuantityUC10<>(1.0, VolumeUnitUC11.GALLON);
        double result = gallon.convertTo(VolumeUnitUC11.LITRE);
        assertEquals(3.785, result, 0.001); //
    }

    @Test
    public void testAddition_CrossUnit_LitrePlusGallon() {
        QuantityUC10<VolumeUnitUC11> litre = new QuantityUC10<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC10<VolumeUnitUC11> gallon = new QuantityUC10<>(1.0, VolumeUnitUC11.GALLON);
        QuantityUC10<VolumeUnitUC11> result = litre.add(gallon, VolumeUnitUC11.LITRE);
        assertEquals(4.785, result.getValue(), 0.001); //
    }

    @Test
    public void testVolumeVsWeight_Incompatible() {
        QuantityUC10<VolumeUnitUC11> litre = new QuantityUC10<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC10<WeightUnitUC10> kg = new QuantityUC10<>(1.0, WeightUnitUC10.KILOGRAM);
        assertFalse(litre.equals(kg)); //
    }
}
```</U>