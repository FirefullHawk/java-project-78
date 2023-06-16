package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean positiveCheckActive = false;
    private boolean rangeCheckActive = false;
    private int startRange;
    private int endRange;

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    @Override
    public boolean isValid(Object inputData) {
        boolean positiveCheck;
        try {
            positiveCheck = !positiveCheckActive || (Integer) inputData > 0;
        } catch (RuntimeException e) {
            positiveCheck = true;
        }
        boolean typeCheck = inputData instanceof Integer || super.isValid(inputData);
        boolean rangeCheck = !rangeCheckActive || isInRange(inputData, startRange, endRange);
        return typeCheck && rangeCheck && positiveCheck;
    }

    public NumberSchema positive() {
        positiveCheckActive = true;
        return this;
    }

    public NumberSchema range(int startRangeInput, int endRangeInput) {
        rangeCheckActive = true;
        startRange = startRangeInput;
        endRange = endRangeInput;
        return this;
    }

    private boolean isInRange(Object inputData, int start, int end) {
        return (Integer) inputData >= start && (Integer) inputData <= end;
    }
}
