package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityUC12<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public QuantityUC12(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() { return value; }
    public U getUnit() { return unit; }

    private void validateCategory(QuantityUC12<?> other) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible measurement categories");
        }
    }

    public QuantityUC12<U> subtract(QuantityUC12<U> other) {
        return subtract(other, this.unit);
    }

    public QuantityUC12<U> subtract(QuantityUC12<U> other, U targetUnit) {
        validateCategory(other);
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double differenceInBase = this.unit.convertToBaseUnit(this.value) -
                other.unit.convertToBaseUnit(other.value);

        double finalValue = targetUnit.convertFromBaseUnit(differenceInBase);
        return new QuantityUC12<>(finalValue, targetUnit);
    }

    public double divide(QuantityUC12<U> other) {
        validateCategory(other);
        double divisorBase = other.unit.convertToBaseUnit(other.value);
        if (divisorBase == 0) throw new ArithmeticException("Division by zero");

        return this.unit.convertToBaseUnit(this.value) / divisorBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityUC12<?> that = (QuantityUC12<?>) obj;
        if (this.unit.getClass() != that.unit.getClass()) return false;
        return Double.compare(this.unit.convertToBaseUnit(this.value),
                ((IMeasurable)that.unit).convertToBaseUnit(that.value)) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}