package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapValidatorTest {
    private static Validator validator;
    private static MapSchema mapSchema;
    private static Map<String, Object> inputMap;
    @BeforeAll
    public static void inputValidate() {
        validator = new Validator();
        inputMap = Map.of("Cookies", "Oreo", "Value", 100);
    }

    @BeforeEach
    public void inputScheme() {
        mapSchema = validator.map();
    }
    @Test
    public void nullValid() {
        assertTrue(mapSchema.isValid(null));
        assertFalse(mapSchema.required().isValid(null));
    }
    @Test
    public void mapValid() {
        assertFalse(mapSchema.isValid(114));
        assertTrue(mapSchema.required().isValid(inputMap));
    }

    @Test
    public void mapSize() {
        assertFalse(mapSchema.sizeof(3).isValid(new HashMap<>()));
        assertTrue(mapSchema.sizeof(2).isValid(inputMap));
    }

    @Test
    public void mapShape() {
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
