package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    @Override
    public NumberSchema required() {
        Predicate<Object> typeCheck =
                inputDate -> inputDate instanceof Integer;

        addCheck(typeCheck);

        super.required();
        return this;
    }

    @Override
    public boolean isValid(Object inputData) {
        return super.isValid(inputData);
    }

    public NumberSchema positive() {
        Predicate<Object> positive =
                    inputDate -> {
                        try {
                            return (Integer) inputDate > 0;
                        } catch (RuntimeException e) {
                            return true;
                        }
                    };
        addCheck(positive);
        return this;
    }

    public NumberSchema range(int startRangeInput, int endRangeInput) {
        Predicate<Object> range =
                inputDate -> isInRange(inputDate, startRangeInput, endRangeInput);
        addCheck(range);
        return this;
    }

    private boolean isInRange(Object inputData, int start, int end) {
        return (Integer) inputData >= start && (Integer) inputData <= end;
    }
}
