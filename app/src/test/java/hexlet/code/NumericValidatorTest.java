package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumericValidatorTest {
    private NumberSchema numberSchema;

    @BeforeEach
    public void inputSchemeTest() {
        Validator validator = new Validator();
        numberSchema = validator.number();
    }
    @Test
    public void integerValidTest() {
        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid(111));

        assertFalse(numberSchema.required().isValid(null));
        assertFalse(numberSchema.isValid("inputNumber"));
        assertFalse(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid(4.55));
    }

    @Test
    public void integerPositiveTest() {
        assertTrue(numberSchema.positive().isValid(null));
        assertFalse(numberSchema.positive().isValid(-111));
    }

    @Test
    public void integerRangeTest() {
        assertTrue(numberSchema.range(110, 120).isValid(111));
        assertTrue(numberSchema.range(110, 120).isValid(110));
        assertTrue(numberSchema.range(110, 120).isValid(120));

        assertFalse(numberSchema.isValid(70));
        assertFalse(numberSchema.isValid(170));
    }
}
