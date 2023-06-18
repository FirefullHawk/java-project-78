package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumericValidatorTest {
    private static Validator validator;
    private static NumberSchema numberSchema;
    private static Integer inputNumber;
    @BeforeAll
    public static void inputValidate() {
        validator = new Validator();
        inputNumber = 111;
    }

    @BeforeEach
    public void inputScheme() {
        numberSchema = validator.number();
    }
    @Test
    public void nullValid() {
        assertTrue(numberSchema.isValid(null));
        assertFalse(numberSchema.required().isValid(null));
    }
    @Test
    public void integerValid() {
        assertFalse(numberSchema.required().isValid("inputNumber"));
        assertFalse(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid(inputNumber));
    }

    @Test
    public void integerPositive() {
        assertTrue(numberSchema.positive().isValid(null));
        assertFalse(numberSchema.positive().isValid(-inputNumber));
    }

    @Test
    public void integerRange() {
        assertTrue(numberSchema.range(110, 120).isValid(inputNumber));
        assertFalse(numberSchema.isValid(70) || numberSchema.isValid(170));
    }
}
