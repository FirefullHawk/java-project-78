package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
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
        boolean emptyString = inputData.equals("");
        boolean minLengthCheck = !lengthCheckActive || inputData.toString().length() >= minLength;
        boolean containsCheck = !containsCheckActive || inputData.toString().contains(containsSubscribing);
        boolean typeCheck = inputData instanceof String && !emptyString || super.isValid(inputData) && emptyString;
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
