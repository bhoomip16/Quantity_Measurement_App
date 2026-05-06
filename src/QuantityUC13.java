package com.apps.quantitymeasurement;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public class QuantityUC13<U extends IMeasurable> {
    private final double value;
    private final U unit;

    /**
     * Internal Enum to dispatch arithmetic operations using Lambdas.
     * Enforces DRY by decoupling the mathematical logic from the conversion boilerplate.
     */
    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public double compute(double v1, double v2) {
            return operator.applyAsDouble(v1, v2);
        }
    }

    public QuantityUC13(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    /**
     * Centralized validation helper to ensure consistent error handling.
     */
    private void validateArithmeticOperands(QuantityUC13<U> other, U targetUnit, boolean targetUnitRequired) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible measurement categories");
        }
        if (targetUnitRequired && targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
    }

    /**
     * Core helper method that handles normalization to base units and execution of operations.
     */
    private double performBaseArithmetic(QuantityUC13<U> other, ArithmeticOperation operation) {
        double v1Base = this.unit.convertToBaseUnit(this.value);
        double v2Base = other.unit.convertToBaseUnit(other.value);
        return operation.compute(v1Base, v2Base);
    }

    // --- Public API Methods ---

    public QuantityUC13<U> add(QuantityUC13<U> other) {
        return add(other, this.unit);
    }

    public QuantityUC13<U> add(QuantityUC13<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.ADD);
        return new QuantityUC13<>(targetUnit.convertFromBaseUnit(resultBase), targetUnit);
    }

    public QuantityUC13<U> subtract(QuantityUC13<U> other) {
        return subtract(other, this.unit);
    }

    public QuantityUC13<U> subtract(QuantityUC13<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double resultBase = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        return new QuantityUC13<>(targetUnit.convertFromBaseUnit(resultBase), targetUnit);
    }

    public double divide(QuantityUC13<U> other) {
        validateArithmeticOperands(other, null, false);
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityUC13<?> that = (QuantityUC13<?>) obj;
        if (this.unit.getClass() != that.unit.getClass()) return false;
        return Double.compare(this.unit.convertToBaseUnit(this.value),
                ((IMeasurable)that.unit).convertToBaseUnit(that.value)) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}