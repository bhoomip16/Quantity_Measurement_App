package com.apps.quantitymeasurement;

import java.util.Objects;

public class LengthUC7 {
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

    public LengthUC7(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
        double convertedValue = lengthInInches / targetUnit.getConversionFactor();
        return Math.round(convertedValue * 1000.0) / 1000.0;
    }

    private LengthUC7 addAndConvert(LengthUC7 thatLength, LengthUnit targetUnit) {
        if (thatLength == null || targetUnit == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        double totalInches = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double finalValue = convertFromBaseToTargetUnit(totalInches, targetUnit);
        return new LengthUC7(finalValue, targetUnit);
    }

    public LengthUC7 add(LengthUC7 thatLength) {
        return addAndConvert(thatLength, this.unit);
    }

    public LengthUC7 add(LengthUC7 thatLength, LengthUnit targetUnit) {
        return addAndConvert(thatLength, targetUnit);
    }

    public LengthUC7 convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInInches = convertToBaseUnit();
        double roundedValue = convertFromBaseToTargetUnit(valueInInches, targetUnit);
        return new LengthUC7(roundedValue, targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthUC7 that = (LengthUC7) o;
        return Double.compare(Math.round(this.convertToBaseUnit() * 100.0) / 100.0,
                Math.round(that.convertToBaseUnit() * 100.0) / 100.0) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, unit);
    }
}