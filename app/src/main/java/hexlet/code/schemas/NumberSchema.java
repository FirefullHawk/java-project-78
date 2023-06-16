package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean positiveCheckActive = false;
    private boolean rangeCheckActive = false;
    private int startRange;
    private int endRange;
    @Override
    public boolean isValid(Object inputData) {
        boolean positiveCheck = !positiveCheckActive || (Integer) inputData >= 0;
        boolean rangeCheck = !rangeCheckActive || isInRange(inputData, startRange, endRange);
        boolean typeCheck = inputData instanceof Integer || super.isValid(inputData);
        return positiveCheck && rangeCheck && typeCheck;
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
