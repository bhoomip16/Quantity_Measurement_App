package com.apps.quantitymeasurement;

import java.util.Objects;

public class LengthUC8 {
    private final double value;
    private final LengthUnitUC8 unit;

    public LengthUC8(double value, LengthUnitUC8 unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public LengthUC8 convertTo(LengthUnitUC8 targetUnit) {
        double valueInBase = unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(valueInBase);
        return new LengthUC8(convertedValue, targetUnit);
    }

    public LengthUC8 add(LengthUC8 thatLength) {
        return add(thatLength, this.unit);
    }

    public LengthUC8 add(LengthUC8 thatLength, LengthUnitUC8 targetUnit) {
        double totalBase = this.unit.convertToBaseUnit(this.value) +
                thatLength.unit.convertToBaseUnit(thatLength.value);
        double finalValue = targetUnit.convertFromBaseUnit(totalBase);
        return new LengthUC8(finalValue, targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthUC8 that = (LengthUC8) o;
        return Double.compare(this.unit.convertToBaseUnit(this.value),
                that.unit.convertToBaseUnit(that.value)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}