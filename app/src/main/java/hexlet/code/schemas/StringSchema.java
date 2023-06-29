package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    @Override
    public StringSchema required() {
        Predicate<Object> required =
                input -> Objects.nonNull(input) && !input.toString().isEmpty();
        addCheck(required);
        return this;
    }

    public StringSchema() {
        Predicate<Object> typeCheck =
                input -> input == null || input instanceof String;
        addCheck(typeCheck);
    }

    public StringSchema minLength(int minStringLength) {
        Predicate<Object> minLength =
                input -> input == null || input.toString().length() >= minStringLength;
        addCheck(minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<Object> contains =
                input -> input == null || input.toString().contains(substring);
        addCheck(contains);
        return this;
    }
}
