package com.apps.quantitymeasurement;

public class QuantityMeasurementAppUC9 {

    public static boolean demonstrateWeightEquality(WeightUC9 w1, WeightUC9 w2) {
        return w1 != null && w1.equals(w2);
    }

    public static WeightUC9 demonstrateWeightConversion(double value, WeightUnitUC9 from, WeightUnitUC9 to) {
        return new WeightUC9(value, from).convertTo(to);
    }

    public static WeightUC9 demonstrateWeightAddition(WeightUC9 w1, WeightUC9 w2, WeightUnitUC9 target) {
        return w1.add(w2, target);
    }

    public static void main(String[] args) {
        WeightUC9 weight1 = new WeightUC9(1.0, WeightUnitUC9.KILOGRAM);
        WeightUC9 weight2 = new WeightUC9(1000.0, WeightUnitUC9.GRAM);

        System.out.println("Is 1kg equal to 1000g? " + demonstrateWeightEquality(weight1, weight2));

        WeightUC9 sum = demonstrateWeightAddition(weight1, new WeightUC9(1.0, WeightUnitUC9.POUND), WeightUnitUC9.GRAM);
        System.out.println("Sum of 1kg and 1lb in grams: " + sum);
    }
}