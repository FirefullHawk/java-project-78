package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringValidatorTest {
    private static StringSchema stringSchema;

    @BeforeEach
    public void inputSchemeTest() {
        Validator validator = new Validator();
        stringSchema = validator.string();
    }
    @Test
    public void stringValidTest() {
        assertTrue(stringSchema.isValid(null) && stringSchema.isValid(""));
        assertFalse(stringSchema.required().isValid(null) && stringSchema.isValid(""));
        assertTrue(stringSchema.required().isValid("What does just one fox"));
    }

    @Test
    public void stringMinLengthTest() {
        assertFalse(stringSchema.minLength(5).isValid("fox"));
        assertTrue(stringSchema.minLength(5).isValid("What does just one fox"));
    }

    @Test
    public void stringContainsTest() {
        assertTrue(stringSchema.contains("Wh").isValid("What does just one fox"));
        assertFalse(stringSchema.contains("Hat").isValid("What does just one fox"));
    }
}
