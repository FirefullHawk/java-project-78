package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapValidatorTest {
    private static final Validator VALIDATOR = new Validator();
    private static MapSchema mapSchema;

    @BeforeEach
    public void inputSchemeTest() {
        mapSchema = VALIDATOR.map();
    }
    @Test
    public void mapValidTest() {
        Map<String, Object> inputMap = new HashMap<>();

        assertFalse(mapSchema.isValid(114));
        assertTrue(mapSchema.isValid(null));
        assertTrue(mapSchema.required().isValid(inputMap));
        assertFalse(mapSchema.isValid(null));
    }

    @Test
    public void mapSizeTest() {
        Map<String, Object> inputMap = Map.of("Cookies", "Oreo", "Value", 7);

        assertFalse(mapSchema.sizeof(2).isValid(new HashMap<>()));
        assertTrue(mapSchema.sizeof(2).isValid(inputMap));
    }

    @Test
    public void mapShapeTest() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("Cookies", VALIDATOR.string().required());
        schemas.put("Value", VALIDATOR.number().positive());

        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("Cookies", "Oreo");
        inputMap.put("Value", 7);

        assertTrue(mapSchema.shape(schemas).isValid(inputMap));

        Map<String, Object> anotherInputMap = Map.of("Cookies", "", "Value", -100);
        assertFalse(mapSchema.isValid(anotherInputMap));

        Map<String, Object> oneMoreInputMap = new HashMap<>();
        oneMoreInputMap.put("Cookies", "Tuc");
        oneMoreInputMap.put("Value", null);
        assertTrue(mapSchema.isValid(oneMoreInputMap));
    }
}
