package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC6 {

    public static boolean demonstrateLengthEquality(LengthUC6 length1, LengthUC6 length2) {
        return length1 != null && length1.equals(length2);
    }

    public static LengthUC6 demonstrateLengthAddition(LengthUC6 length1, LengthUC6 length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Lengths cannot be null");
        }
        return length1.add(length2);
    }

    public static void main(String[] args) {
        LengthUC6 l1 = new LengthUC6(1.0, LengthUC6.LengthUnit.FEET);
        LengthUC6 l2 = new LengthUC6(12.0, LengthUC6.LengthUnit.INCHES);
        System.out.println("Result: " + demonstrateLengthAddition(l1, l2));
    }
}