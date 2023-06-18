package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringValidatorTest {
    private static Validator validator;
    private static StringSchema stringSchema;
    private static String inputString;
    @BeforeAll
    public static void inputValidate() {
        validator = new Validator();
        inputString = "What does just 1 fox";
    }

    @BeforeEach
    public void inputScheme() {
        stringSchema = validator.string();
    }
    @Test
    public void nullValid() {
        assertTrue(stringSchema.isValid(null));
        assertFalse(stringSchema.required().isValid(null));
    }
    @Test
    public void stringValid() {
        assertTrue(stringSchema.required().isValid(inputString));
        assertFalse(stringSchema.isValid(""));
    }

    @Test
    public void stringMinLength() {
        assertTrue(stringSchema.minLength(5).isValid(inputString));
    }

    @Test
    public void stringContains() {
        assertTrue(stringSchema.contains("Wh").isValid(inputString));
        assertFalse(stringSchema.contains("Hat").isValid(inputString));
    }
}
