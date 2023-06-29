package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema() {
        Predicate<Object> typeCheck =
                input -> input == null || input instanceof Map<?, ?>;
        addCheck(typeCheck);
    }

    public MapSchema sizeof(int inputSize) {
        Predicate<Object> sizeof =
                input -> input == null || ((Map<?, ?>) input).size() >= inputSize;
        addCheck(sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> inputSchema) {

        Predicate<Object> shape =
                input -> input == null || inputSchema.keySet()
                        .stream().allMatch(key -> {
                            Object valueInput = ((Map<?, ?>) input).get(key);
                            return inputSchema.get(key).isValid(valueInput);
                        });
        addCheck(shape);
        return this;
    }
}
