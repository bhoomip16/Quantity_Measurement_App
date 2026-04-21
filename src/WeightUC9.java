package com.apps.quantitymeasurement;

import java.util.Objects;

public class WeightUC9 {
    private final double value;
    private final WeightUnitUC9 unit;

    public WeightUC9(double value, WeightUnitUC9 unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public WeightUC9 convertTo(WeightUnitUC9 targetUnit) {
        double valueInBase = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(valueInBase);
        return new WeightUC9(convertedValue, targetUnit);
    }

    public WeightUC9 add(WeightUC9 thatWeight) {
        return add(thatWeight, this.unit);
    }

    public WeightUC9 add(WeightUC9 thatWeight, WeightUnitUC9 targetUnit) {
        double totalBase = this.unit.convertToBaseUnit(this.value) +
                thatWeight.unit.convertToBaseUnit(thatWeight.value);
        double finalValue = targetUnit.convertFromBaseUnit(totalBase);
        return new WeightUC9(finalValue, targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightUC9 that = (WeightUC9) o;
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