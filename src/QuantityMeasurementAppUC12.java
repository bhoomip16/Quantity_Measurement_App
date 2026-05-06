package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC12 {

    public static <U extends IMeasurable> QuantityUC12<U> demonstrateSubtraction(QuantityUC12<U> q1, QuantityUC12<U> q2, U targetUnit) {
        return q1.subtract(q2, targetUnit);
    }

    public static <U extends IMeasurable> double demonstrateDivision(QuantityUC10<U> q1, QuantityUC10<U> q2) {
        return q1.divide(q2);
    }

    public static void main(String[] args) {
        // Subtraction Example
        QuantityUC12<LengthUnitUC10> l1 = new QuantityUC12<>(10.0, LengthUnitUC10.FEET);
        QuantityUC12<LengthUnitUC10> l2 = new QuantityUC12<>(6.0, LengthUnitUC10.INCHES);
        System.out.println("10 Feet - 6 Inches in Feet: " + l1.subtract(l2));

        // Division Example
        QuantityUC12<WeightUnitUC10> w1 = new QuantityUC12<>(10.0, WeightUnitUC10.KILOGRAM);
        QuantityUC12<WeightUnitUC10> w2 = new QuantityUC12<>(5.0, WeightUnitUC10.KILOGRAM);
        System.out.println("10kg / 5kg = " + w1.divide(w2));
    }
}