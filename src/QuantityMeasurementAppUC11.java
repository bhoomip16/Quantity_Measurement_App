package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC11 {

    public static void main(String[] args) {
        // Equality Comparisons
        QuantityUC10<VolumeUnitUC11> litre = new QuantityUC10<>(1.0, VolumeUnitUC11.LITRE);
        QuantityUC10<VolumeUnitUC11> ml = new QuantityUC10<>(1000.0, VolumeUnitUC11.MILLILITRE);
        System.out.println("Are 1L and 1000mL equal? " + QuantityMeasurementAppUC10.demonstrateEquality(litre, ml)); // Output: true

        // Unit Conversions
        QuantityUC10<VolumeUnitUC11> gallon = new QuantityUC10<>(1.0, VolumeUnitUC11.GALLON);
        System.out.println("1 Gallon in Litres: " + gallon.convertTo(VolumeUnitUC11.LITRE)); // Output: 3.785

        // Addition Operations
        QuantityUC10<VolumeUnitUC11> totalVolume = litre.add(gallon, VolumeUnitUC11.LITRE);
        System.out.println("Sum of 1L and 1 Gallon in Litres: " + totalVolume); // Output: 4.785 Litre

        // Category Incompatibility Check
        QuantityUC10<LengthUnitUC10> foot = new QuantityUC10<>(1.0, LengthUnitUC10.FEET);
        // The following would return false due to different enum class types in equals()
        System.out.println("Is 1L equal to 1 Foot? " + litre.equals(foot));
    }
}