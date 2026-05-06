package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityUC10<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public QuantityUC10(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public double convertTo(U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = unit.convertToBaseUnit(this.value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public QuantityUC10<U> add(QuantityUC10<U> other) {
        return add(other, this.unit);
    }

    public QuantityUC10<U> add(QuantityUC10<U> other, U targetUnit) {
        if (other == null || targetUnit == null) throw new IllegalArgumentException("Parameters cannot be null");
        double sumInBase = this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);
        return new QuantityUC10<>(targetUnit.convertFromBaseUnit(sumInBase), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityUC10<?> that = (QuantityUC10<?>) obj;

        if (this.unit.getClass() != that.unit.getClass()) return false;

        return Double.compare(this.unit.convertToBaseUnit(this.value),
                ((IMeasurable)that.unit).convertToBaseUnit(that.value)) == 0;
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