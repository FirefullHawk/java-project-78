package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumericValidatorTest {
    private static final Validator validator = new Validator();
    private static NumberSchema numberSchema;

    @BeforeEach
    public void inputSchemeTest() {
        numberSchema = validator.number();
    }
    @Test
    public void integerValidTest() {
        assertTrue(numberSchema.isValid(null));
        assertFalse(numberSchema.required().isValid(null));
        assertFalse(numberSchema.isValid("inputNumber"));
        assertFalse(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid(111));
    }

    @Test
    public void integerPositiveTest() {
        assertTrue(numberSchema.positive().isValid(null));
        assertFalse(numberSchema.positive().isValid(-111));
    }

    @Test
    public void integerRangeTest() {
        assertTrue(numberSchema.range(110, 120).isValid(111));
        assertFalse(numberSchema.isValid(70) || numberSchema.isValid(170));
    }
}
