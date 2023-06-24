package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        Predicate<Object> typeCheck =
                input -> input instanceof String || input == null;
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
                input -> input.toString().contains(substring);
        addCheck(contains);
        return this;
    }
}
