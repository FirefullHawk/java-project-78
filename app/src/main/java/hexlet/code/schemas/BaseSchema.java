package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema {
    private final static List<Predicate<Object>> checks = new ArrayList<>();
    protected static void addCheck(Predicate<Object> validate) {
        checks.add(validate);
    }

    /**
     * This function add the required check.
     * @return scheme-type
     */
    public final BaseSchema required() {
        Predicate<Object> required =
                input -> Objects.nonNull(input) && !Objects.equals(input, "");
        addCheck(required);
        return this;
    }

    /**
     * This function check empty and null input.
     @return valid or not input object
     @param inputData is Object which must be validated
     */
    public final boolean isValid(Object inputData) {
        return checks.stream()
                .allMatch(check -> check.test(inputData));
    }
}
