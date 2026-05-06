package com.apps.quantitymeasurement;

public enum VolumeUnitUC11 implements IMeasurable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnitUC11(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return Math.round((value * conversionFactor) * 1000.0) / 1000.0;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return Math.round((baseValue / conversionFactor) * 1000.0) / 1000.0;
    }
}