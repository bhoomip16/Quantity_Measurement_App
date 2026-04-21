package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC7 {

    public static boolean demonstrateLengthEquality(LengthUC7 length1, LengthUC7 length2) {
        return length1 != null && length1.equals(length2);
    }

    public static LengthUC7 demonstrateLengthAddition(LengthUC7 length1, LengthUC7 length2) {
        return length1.add(length2);
    }

    public static LengthUC7 demonstrateLengthAddition(LengthUC7 length1, LengthUC7 length2, LengthUC7.LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {
        LengthUC7 l1 = new LengthUC7(1.0, LengthUC7.LengthUnit.FEET);
        LengthUC7 l2 = new LengthUC7(12.0, LengthUC7.LengthUnit.INCHES);

        System.out.println("Result in Feet: " + demonstrateLengthAddition(l1, l2, LengthUC7.LengthUnit.FEET));
        System.out.println("Result in Yards: " + demonstrateLengthAddition(l1, l2, LengthUC7.LengthUnit.YARDS));
    }
}