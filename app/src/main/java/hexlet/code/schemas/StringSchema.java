package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    private boolean lengthCheckActive = false;
    private boolean containsCheckActive = false;
    private String containsSubscribing;
    private int minLength;

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    @Override
    public boolean isValid(Object inputData) {
        boolean minLengthCheck = !lengthCheckActive || inputData.toString().length() >= minLength;
        boolean containsCheck = !containsCheckActive || inputData.toString().contains(containsSubscribing);
        boolean typeCheck = inputData instanceof String && !((String) inputData).isEmpty() || super.isValid(inputData);
        return minLengthCheck && containsCheck && typeCheck;
    }

    public StringSchema minLength(int minLengthInput) {
        lengthCheckActive = true;
        minLength = minLengthInput;
        return this;
    }

    public StringSchema contains(String substring) {
        containsCheckActive = true;
        containsSubscribing = substring;
        return this;
    }
}
