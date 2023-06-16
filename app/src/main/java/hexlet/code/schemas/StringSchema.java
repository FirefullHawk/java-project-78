package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private boolean lengthCheckActive = false;
    private boolean containsCheckActive = false;
    private String containsSubscribing;
    private int minLength;

    @Override
    public boolean isValid(Object inputData) {
        boolean minLengthCheck = !lengthCheckActive || inputData.toString().length() >= minLength;
        boolean containsCheck = !containsCheckActive || inputData.toString().contains(containsSubscribing);
        boolean typeCheck = inputData instanceof String || super.isValid(inputData);
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