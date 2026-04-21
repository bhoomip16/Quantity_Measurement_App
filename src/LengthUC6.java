package com.apps.quantitymeasurement;

import java.util.Objects;

public class LengthUC6 {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public LengthUC6(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
        double convertedValue = lengthInInches / targetUnit.getConversionFactor();
        return Math.round(convertedValue * 100.0) / 100.0;
    }

    public LengthUC6 convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInInches = convertToBaseUnit();
        double roundedValue = convertFromBaseToTargetUnit(valueInInches, targetUnit);
        return new LengthUC6(roundedValue, targetUnit);
    }

    public LengthUC6 add(LengthUC6 thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        double totalInches = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double finalValue = convertFromBaseToTargetUnit(totalInches, this.unit);
        return new LengthUC6(finalValue, this.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthUC6 that = (LengthUC6) o;
        return Double.compare(Math.round(this.convertToBaseUnit() * 100.0) / 100.0,
                Math.round(that.convertToBaseUnit() * 100.0) / 100.0) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}