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
    public void inputSchemeTest() {
        stringSchema = validator.string();
    }
    @Test
    public void nullValidTest() {
        assertTrue(stringSchema.isValid(null));
        assertFalse(stringSchema.required().isValid(null));
    }
    @Test
    public void stringValidTest() {
        assertTrue(stringSchema.required().isValid(inputString));
        assertFalse(stringSchema.isValid(""));
    }

    @Test
    public void stringMinLengthTest() {
        assertTrue(stringSchema.minLength(5).isValid(inputString));
    }

    @Test
    public void stringContainsTest() {
        assertTrue(stringSchema.contains("Wh").isValid(inputString));
        assertFalse(stringSchema.contains("Hat").isValid(inputString));
    }
}
