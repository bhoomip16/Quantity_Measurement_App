package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC5 {

    public static boolean demonstrateLengthEquality(LengthUC5 length1, LengthUC5 length2) {
        return length1 != null && length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(double v1, LengthUC5.LengthUnit u1, double v2, LengthUC5.LengthUnit u2) {
        LengthUC5 length1 = new LengthUC5(v1, u1);
        LengthUC5 length2 = new LengthUC5(v2, u2);
        return demonstrateLengthEquality(length1, length2);
    }

    public static LengthUC5 demonstrateLengthConversion(double value, LengthUC5.LengthUnit fromUnit, LengthUC5.LengthUnit toUnit) {
        LengthUC5 sourceLength = new LengthUC5(value, fromUnit);
        return sourceLength.convertTo(toUnit);
    }

    public static LengthUC5 demonstrateLengthConversion(LengthUC5 length, LengthUC5.LengthUnit toUnit) {
        if (length == null) throw new IllegalArgumentException("Length object cannot be null");
        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {
        LengthUC5 inches = demonstrateLengthConversion(3.0, LengthUC5.LengthUnit.FEET, LengthUC5.LengthUnit.INCHES);
        System.out.println("3 Feet to Inches: " + inches);

        LengthUC5 feet = demonstrateLengthConversion(2.0, LengthUC5.LengthUnit.YARDS, LengthUC5.LengthUnit.FEET);
        System.out.println("2 Yards to Feet: " + feet);

        LengthUC5 yardFromInches = demonstrateLengthConversion(36.0, LengthUC5.LengthUnit.INCHES, LengthUC5.LengthUnit.YARDS);
        System.out.println("36 Inches to Yards: " + yardFromInches);
    }
}