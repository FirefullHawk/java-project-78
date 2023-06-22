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
    public void inputSchemeTest() {
        numberSchema = validator.number();
    }
    @Test
    public void nullValidTest() {
        assertTrue(numberSchema.isValid(null));
        assertFalse(numberSchema.required().isValid(null));
    }
    @Test
    public void integerValidTest() {
        assertFalse(numberSchema.required().isValid("inputNumber"));
        assertFalse(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid(inputNumber));
    }

    @Test
    public void integerPositiveTest() {
        assertTrue(numberSchema.positive().isValid(null));
        assertFalse(numberSchema.positive().isValid(-inputNumber));
    }

    @Test
    public void integerRangeTest() {
        assertTrue(numberSchema.range(110, 120).isValid(inputNumber));
        assertFalse(numberSchema.isValid(70) || numberSchema.isValid(170));
    }
}
