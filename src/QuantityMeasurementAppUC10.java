package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC10 {

    public static <U extends IMeasurable> boolean demonstrateEquality(QuantityUC10<U> q1, QuantityUC10<U> q2) {
        return q1 != null && q1.equals(q2);
    }

    public static <U extends IMeasurable> QuantityUC10<U> demonstrateConversion(QuantityUC10<U> q, U targetUnit) {
        double result = q.convertTo(targetUnit);
        return new QuantityUC10<>(result, targetUnit);
    }

    public static <U extends IMeasurable> QuantityUC10<U> demonstrateAddition(QuantityUC10<U> q1, QuantityUC10<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {
        QuantityUC10<LengthUnitUC10> l1 = new QuantityUC10<>(1.0, LengthUnitUC10.FEET);
        QuantityUC10<LengthUnitUC10> l2 = new QuantityUC10<>(12.0, LengthUnitUC10.INCHES);
        System.out.println("Are lengths equal? " + demonstrateEquality(l1, l2));

        QuantityUC10<WeightUnitUC10> w1 = new QuantityUC10<>(1.0, WeightUnitUC10.KILOGRAM);
        QuantityUC10<WeightUnitUC10> w2 = new QuantityUC10<>(1000.0, WeightUnitUC10.GRAM);
        System.out.println("Are weights equal? " + demonstrateEquality(w1, w2));
    }
}