package com.apps.quantitymeasurement;

public enum WeightUnitUC10 implements IMeasurable {
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1000000.0),
    MILLIGRAM(0.001);

    private final double conversionFactor;

    WeightUnitUC10(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return Math.round((value * conversionFactor) * 100.0) / 100.0;
    }

    public double convertFromBaseUnit(double baseValue) {
        return Math.round((baseValue / conversionFactor) * 100.0) / 100.0;
    }
}