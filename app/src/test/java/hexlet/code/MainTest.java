package hexlet.code;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MainTest {
    private static Validator validator;
    private static StringSchema stringSchema;
    private static NumberSchema numberSchema;
    private static MapSchema mapSchema;
    @BeforeAll
    public static void validatorStringScheme() {
        validator = new Validator();
        stringSchema = validator.string();
        numberSchema = validator.number();
        mapSchema = validator.map();
    }

    private static Stream<? super BaseSchema> enumeration() {

        return Stream.of(
                stringSchema,
                numberSchema,
                mapSchema);
    }

    @ParameterizedTest
    @MethodSource("enumeration")
    public void nullTest(BaseSchema schema) {
        assertTrue(schema.isValid(null));
        assertFalse(schema.required().isValid(null));
    }

    @Test
    public void workingString() {
        String inputString = "What does just 1 fox";
        assertTrue(stringSchema.required().isValid(inputString));
        assertFalse(stringSchema.isValid(""));
        assertTrue(stringSchema.minLength(5).isValid(inputString));
        assertTrue(stringSchema.contains("Wh").isValid(inputString));
    }

    @Test
    public void workingInteger() {
        int inputNumber = 116;
        assertFalse(numberSchema.required().isValid("inputNumber"));
        assertFalse(numberSchema.positive().isValid(-inputNumber));
        assertFalse(numberSchema.isValid(null));
        assertTrue(numberSchema.range(110, 120).isValid(inputNumber));
        assertFalse(numberSchema.isValid(70) || numberSchema.isValid(170));
    }

    @Test
    public void workingMap() {
        Map<String, Object> inputMap = Map.of("Cookies", "Oreo", "Value", 100);
        assertFalse(mapSchema.required().isValid(114));
        assertTrue(mapSchema.sizeof(2).isValid(inputMap));

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("Cookies", validator.string().required());
        schemas.put("Value", validator.number().positive());

        assertTrue(mapSchema.shape(schemas).isValid(inputMap));

        Map<String, Object> anotherInputMap = Map.of("Cookies", "", "Value", -100);
        assertFalse(mapSchema.isValid(anotherInputMap));

        Map<String, Object> oneMoreInputMap = new HashMap<>();
        oneMoreInputMap.put("Cookies", "Tuc");
        oneMoreInputMap.put("Value", null);
        assertTrue(mapSchema.isValid(oneMoreInputMap));
    }
}
