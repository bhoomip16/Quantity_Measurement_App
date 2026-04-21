package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC8 {

    public static boolean demonstrateLengthEquality(LengthUC8 length1, LengthUC8 length2) {
        return length1 != null && length1.equals(length2);
    }

    public static LengthUC8 demonstrateLengthConversion(double value, LengthUnitUC8 from, LengthUnitUC8 to) {
        return new LengthUC8(value, from).convertTo(to);
    }

    public static LengthUC8 demonstrateLengthAddition(LengthUC8 l1, LengthUC8 l2, LengthUnitUC8 target) {
        return l1.add(l2, target);
    }

    public static void main(String[] args) {
        LengthUC8 result = demonstrateLengthAddition(
                new LengthUC8(1.0, LengthUnitUC8.FEET),
                new LengthUC8(12.0, LengthUnitUC8.INCHES),
                LengthUnitUC8.FEET
        );
        System.out.println("Result: " + result);
    }
}