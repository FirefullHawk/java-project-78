package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        Predicate<Object> typeCheck =
                input -> input == null || input instanceof Integer;
        addCheck(typeCheck);
    }

    public NumberSchema positive() {
        Predicate<Object> positive =
                    input -> input == null || (Integer) input > 0;
        addCheck(positive);
        return this;
    }

    public NumberSchema range(int startRange, int endRange) {
        Predicate<Object> range =
                input ->
                        input == null || (((Integer) input) >= startRange && ((Integer) input) <= endRange);
        addCheck(range);
        return this;
    }
}
